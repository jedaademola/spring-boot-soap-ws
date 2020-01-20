FROM openjdk:13-jdk-alpine

MAINTAINER Lukman Arogundade
COPY target/spring-soap-ws-1.0.0.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "/app.jar"]

#CMD ["-jar", "/app.jar"]
#8080:8085 to RUN
#Docker
#---------------
#1. docker build . -t soap-ws-docker
#2. docker run -p 8080:8085 soap-ws-docker if server:port: 8080
#3. docker ps/images: check containers/images