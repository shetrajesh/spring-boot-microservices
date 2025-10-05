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

