FROM ubuntu:latest

MAINTAINER Group 3 "MUM MPP Instagram Project"

RUN apt-get update && apt-get install -y openjdk-8-jdk

WORKDIR /usr/local/bin/

ADD target/InstagramProject-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "InstagramProject-0.0.1-SNAPSHOT.jar"]