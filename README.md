# InstagramProject by Group 3

## 1. How to build a maven project:
```bash
mvn clean install -DskipTests
```


## 2. How to run the application From Dockerfile:

Build the dockerFile to create an image
```bash
docker image build -t group3image .
```
Make sure the image is created (group3image)
```bash
docker image ls
```
pull mongodb image
```bash
docker image pull mongo
```
Create a network where gropu3image and mongodb communicate
```bash
docker network create group3network
```
Run both container on the same network(group3network) consecutively
```bash
docker container run --network group3network --name mongodb-server -p27017:27017 -d --rm mongo
```
```bash
docker container run --network group3network --name insta-app -p8080:8080 -d --rm group3image
```



## 3. How to run the application by downloading the image:

Pull the image from the [Image link](https://hub.docker.com/r/ber741/group3image)
```bash
docker pull ber741/group3image
```
pull mongodb image
```bash
docker image pull mongo
```
Create a network where gropu3image and mongodb communicate
```bash
docker network create group3network
```
Run both container on the same network(group3network) consecutively
```bash
docker container run --network group3network --name mongodb-server -p27017:27017 -d --rm mongo
```
```bash
docker container run --network group3network --name insta-app -p8080:8080 -d --rm ber741/group3image
```

## 4. How to run the application using jar:
* Make sure that you are on the project home directory or jar location
```bash
mvn clean install -DskipTests
java -jar target/InstagramProject-0.0.1-SNAPSHOT.jar
browse to test - http://localhost:8080/home
```

* If you have jar only, please make sure to run the following command on the jar location:
```bash
java -jar target/InstagramProject-0.0.1-SNAPSHOT.jar
browse to test - http://localhost:8080/home
```

## 5. Other useful commands :
```bash
docker container ls
docker container logs <container id>
docker container stop <conatiner id>

