FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} config-server.jar
ENTRYPOINT ["java", "-jar", "/config-server.jar"]
RUN apt-get update
RUN apt-get install -y curl
EXPOSE 9296
