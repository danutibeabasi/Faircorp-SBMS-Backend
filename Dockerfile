FROM openjdk:17-jdk-alpine
ADD build/libs/faircorp-0.0.1-SNAPSHOT.jar faircorp.jar
ENTRYPOINT ["java", "-jar", "/faircorp.jar"]

# Path: docker-compose.yml


