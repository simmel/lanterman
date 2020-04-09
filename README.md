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
$ # Run with embedded Tomcat
$ java -jar build/libs/lanterman*.war
$ # Deploy in Tomcat
$ cp build/libs/lanterman*.war ~/tomcat/webapps && ~/tomcat/bin/catalina.sh run
$ # Run as a stand alone CLI application
$ java -cp 'log4j2/*:build/libs/lanterman-*.jar' -Djava.util.logging.manager=org.apache.logging.log4j.jul.LogManager se.su.it.logging.lanterman.CLI
```

### TODO

* Add Java 11+ support or at least verify it
* [X] Move Spring Boot-stuff out of `Lanterman` to `Application` class
* [X] Create a `tellMeAboutTheSounds` function and call it from:
  * [X] `main` in `CLI`
  * [X] `home` in `Application`
