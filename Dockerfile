FROM ubuntu:latest AS build

RUN apt update && apt install -y curl
RUN apt install openjdk-17-jdk -y

COPY . /app

RUN apt install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/todolist-1.0.0.jar /app/todolist.jar

ENTRYPOINT ["java", "-jar", "/app/todolist.jar"]

WORKDIR /app