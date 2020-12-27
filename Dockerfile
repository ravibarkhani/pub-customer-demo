FROM adoptopenjdk/openjdk11


COPY target/azure-example*.jar app.jar
EXPOSE 8443 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
