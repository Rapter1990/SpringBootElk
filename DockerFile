# For Java 11,
FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=SpringBootElk.jar

WORKDIR /opt/SpringBootElk

COPY --from=maven /opt/SpringBootElk/target/${JAR_FILE} /opt/SpringBootElk/

ENTRYPOINT ["java","-jar","SpringBootElk.jar"]