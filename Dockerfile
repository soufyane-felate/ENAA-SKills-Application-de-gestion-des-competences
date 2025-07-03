FROM openjdk:17
ADD target/EnaaSkills-0.0.1-SNAPSHOT.jar skills.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","skills.jar"]
