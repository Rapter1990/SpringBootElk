FROM openjdk:21-slim AS build

COPY pom.xml mvnw ./
RUN chmod +x mvnw
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -Dmaven.test.skip

# For Java 11,
#FROM adoptopenjdk/openjdk11:alpine-jre
FROM openjdk:21-slim

WORKDIR SpringBootElk

COPY --from=build target/*.jar SpringBootElk.jar

ENTRYPOINT ["java","-jar","SpringBootElk.jar"]
