FROM openjdk:11
ADD build/libs/faircorp-0.0.1-SNAPSHOT.jar faircorp.jar
ENTRYPOINT ["java", "-jar", "/faircorp.jar"]


