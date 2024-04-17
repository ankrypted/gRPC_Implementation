FROM openjdk:17-jdk-slim-buster
#FROM eclipse-temurin:17-jdk-alpine

ENV ARTIFACT_NAME=gRPCInAction
WORKDIR /app

COPY ./*.jar build/

EXPOSE 8080
EXPOSE 9090

WORKDIR /app/build


ENTRYPOINT java -jar gRPCInAction-0.0.1-SNAPSHOT.jar