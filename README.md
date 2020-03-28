lanterman
---

A simple deployable and executable war which can be deployed to test all known
Java logging libraries to see that you've caught them all with your
configuration.

Currently supported is:
* [Java Commons Logging](https://commons.apache.org/logging)
* [Java Util Logging Interface (JULI)](https://docs.oracle.com/javase/8/docs/api/java/util/logging/package-summary.html)
* [Log4j2](https://logging.apache.org/log4j/2.x/)
* [Log4j](https://logging.apache.org/log4j/1.2/)
* [Logback](https://logback.qos.ch/)
* [SLF4J](https://www.slf4j.org/)

### Usage

```terminal
$ ./gradlew build # A .war is produced in build/libs/
$ java -jar build/libs/lanterman*.war
```

### TODO

* Add Java 11+ support or at least verify it
* Move Spring Boot-stuff out of `Lanterman` to `Application` class
* Create a `cutDownTrees` function and call it from:
  * `main` in `Lanterman`
  * `home` in `Application`
