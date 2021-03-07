# Ktor x Vue Template

### Development

You will need two terminal instances

After clone run `yarn --cwd src-vue install` in project root.

In root directory of project execute:

- Terminal 1: `./gradlew -t run`
- Terminal 2: `yarn --cwd src-vue serve`

### Production

In root directory of project execute:

- Terminal: `./gradlew build`

To run the bundled jar from the `bundle` folder simply run `java -jar bundle/example-0.0.1.jar`. This will not work on
your machine as it wants to use port 80. You can bypass this by running `java -jar bundle/example-0.0.1.jar -port=8080`.
