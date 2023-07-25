FROM openjdk:8-jdk-alpine

EXPOSE 8080

ADD target/springREST-0.0.1-SNAPSHOT.jar.original app.jar

CMD ["java", "-jar", "app.jar"]