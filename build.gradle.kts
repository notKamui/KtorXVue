import org.gradle.jvm.tasks.Jar

val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project


plugins {
    application
    kotlin("jvm") version "1.4.31"
}

group = "com.notkamui"
version = "0.0.1"

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-host-common:$ktorVersion")
    implementation("io.ktor:ktor-gson:$ktorVersion")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")

val fatJar = task("fatJar", type = Jar::class) {
    manifest {
        attributes["Implementation-Title"] = "Ktor - Vue Fat Jar"
        attributes["Implementation-Version"] = project.version
        attributes["Main-Class"] = "io.ktor.server.netty.EngineMain"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
}

val yarnBuild = task<Exec>("yarnBuild") {
    workingDir = file("src-vue")
    commandLine("yarn", "build")
}

val copyDistFolder = tasks.register<Copy>("copyDistFolder") {
    from(file("src-vue/dist"))
    into(file("resources/dist"))
}

var env = "production"

tasks.processResources {
    outputs.upToDateWhen { false }
    filesMatching("*.conf") {
        when (env) {
            "development" -> {
                expand(
                    "KTOR_ENV" to "dev",
                    "KTOR_PORT" to "8081",
                    "KTOR_MODULE" to "build",
                    "KTOR_AUTORELOAD" to "true"
                )
            }
            "production" -> {
                expand(
                    "KTOR_ENV" to "production",
                    "KTOR_PORT" to "80",
                    "KTOR_MODULE" to "",
                    "KTOR_AUTORELOAD" to "false"
                )
            }
        }
    }
}

val setDev = tasks.register("setDev") {
    env = "development"
}

tasks {
    "run" {
        dependsOn(setDev)
    }
    "build" {
        dependsOn(fatJar)
        doLast {
            copy {
                delete("bundle")
                from(fatJar)
                into(file("bundle"))
            }
        }
    }
    "fatJar" {
        dependsOn(copyDistFolder)
    }
    "copyDistFolder" {
        dependsOn(yarnBuild)
    }
}
