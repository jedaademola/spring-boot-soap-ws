FROM openjdk:13-jdk-alpine

MAINTAINER Lukman Arogundade
COPY target/spring-soap-ws-1.0.0.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "/app.jar"]
#CMD ["-jar", "/app.jar"]
#8080:8085 to RUN