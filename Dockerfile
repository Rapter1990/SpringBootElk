FROM openjdk:11 AS build

COPY pom.xml mvnw ./
RUN chmod +x mvnw
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

# For Java 11,
FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR SpringBootElk

COPY --from=build target/*.jar SpringBootElk.jar

ENTRYPOINT ["java","-jar","SpringBootElk.jar"]
