FROM openjdk:8-jre-alpine
EXPOSE 8095
ADD target/spring-boot-json-example.jar spring-boot-json-example.jar
ENTRYPOINT ["java", "-jar", "spring-boot-json-example.jar"]