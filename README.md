# spring-boot-microservices

SDMMan Commands
  sdk list java - To show all java vendors and versions
                - Use Temurin 21 version
  sdk install java 21.0.8-tem

create .sdkmanrc file to specify jdk and maven version

Install maven wrapper for maven commands ( No need to install maven suparately  )
    mvn wrapper:wrapper
=======================================================

nstall Portainer CE with Docker on WSL / Docker Desktop

First, create the volume that Portainer Server will use to store its database:

    docker volume create portainer_data

Then, download and install the Portainer Server container:

    docker run -d -p 8000:8000 -p 9443:9443 --name portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce:lts

Accessing Portainer server
    https://localhost:9443/#!/3/docker/images
    Username : admin        Password : Messi_4252901


Add Swagger dependency ang re-run the app
    http://localhost:8081/swagger-ui/index.html

Create a docker image file for the catalog-service
    ./mvnw -pl catalog-service spring-boot:build-image -DskipTest


Run the docker image file from local registry
    docker run -p 8081:8081 -t catalog-service:0.0.1-SNAPSHOT

Run the docker image file from docker hub registry

    docker run -d \
        --name catalog-service \
        --network bookstore-net \
        -e SPRING_PROFILES_ACTIVE=docker \
        -e DB_URL=jdbc:postgresql://catalog-db:5432/postgres \
        -e DB_USERNAME=postgres \
        -e DB_PASSWORD=postgres \
        -p 8081:8081 \
        rshet007/bookstore-catalog-service:latest
