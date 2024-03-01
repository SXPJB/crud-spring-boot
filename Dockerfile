# Usar una imagen base de Java
FROM gradle:8.6-jdk17 AS build

WORKDIR /app

COPY . .

RUN gradle build

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/crud-spring-boot-0.0.1-SNAPSHOT.jar"]
