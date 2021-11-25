FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} eureka-service.jar
EXPOSE 8761

# bash
RUN apk add --update bash

# Add wait-for-it
ARG SCRIPT=target/classes/*.sh
COPY ${SCRIPT} wait-for-it.sh
RUN chmod +x wait-for-it.sh
ENTRYPOINT [ "/bin/bash" ]


