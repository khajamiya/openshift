# ----OpenShift Training----

### Steps to build docker image and push it to docker hub

##### If you have old installation and you want to clean everything
```
docker system prune -a
```

##### List all Containers
```
docker ps 
```

##### check all existing images
```
docker image ls
```

##### Build Docker Image on local machine
```
docker build -t spring-boot:1.0 .
```

##### Running on local system
```
docker run -d -p 8080:8080 -t spring-boot:1.0
```

##### Stop a docker container by container id
```
docker stop <Container Id>
```

##### Tag first before push to docker hub.
```
docker image tag spring-boot:1.0 <your_id>/spring-boot:1.0
docker image push <your_id>/spring-boot:1.0
```

##### In production server.
```bash
$ docker pull <your_id>/spring-boot:1.0
$ docker run -d -p 80:8080 -t spring-boot:1.0
```
