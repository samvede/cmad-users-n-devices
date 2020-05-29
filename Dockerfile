FROM maven:3.6.1-jdk-8-slim

WORKDIR /app

COPY . . 

RUN mvn package && \
    mv target/emad-event-service.jar /run/users-n-devices.jar && \
    rm -rf /app/*

EXPOSE 30001

CMD java -jar /run/users-n-devices.jar


