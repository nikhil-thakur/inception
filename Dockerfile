FROM openjdk:8
ADD target/inception.jar inception.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "inception.jar"]