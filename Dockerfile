FROM openjdk:17-jdk-slim

MAINTAINER MichajloBear/MychajloBear

COPY target/help-ukraine-0.0.1-SNAPSHOT.jar target/help-ukraine-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "help-ukraine-0.0.1-SNAPSHOT.jar"]
