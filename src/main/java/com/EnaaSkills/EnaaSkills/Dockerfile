FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/competences-management-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]