FROM maven:3.9.6-eclipse-temurin-21-jammy as builder

COPY ./src src/
COPY ./pom.xml pom.xml

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
LABEL authors="danielm"
MAINTAINER deme12.1@gmail.com

VOLUME /tmp

ARG JAR_FILE=target/*.jar
COPY --from=builder ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]