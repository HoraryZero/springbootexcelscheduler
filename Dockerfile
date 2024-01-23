FROM openjdk:21-buster
ARG JAR_FILE=target/*.jar
COPY ./target/springbootexcelscheduler-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]