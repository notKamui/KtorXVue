# Ktor x Vue Template

### Development

You will need two terminal instances

After clone run `yarn install` in the `src-vue` directory.

- In the root directory of the project, execute `./gradlew -t run`
  (or `gradle -t run` if gradle is installed)

- In the `src-vue` directory, execute `yarn serve`

The app will auto-compile on file update

### Production

In root directory of project execute:

- Terminal: `./gradlew build`

To run the bundled jar from the `bundle` folder simply run `java -jar bundle/{jarname}.jar`. This will not work on your
machine as it wants to use port 80. You can bypass this by running `java -jar bundle/{jarname}.jar -port=8080`.
