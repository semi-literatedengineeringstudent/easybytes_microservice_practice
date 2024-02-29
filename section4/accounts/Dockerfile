# before doing docker shit, add <packaging> jar </packaging> under version to obtain jar file
# then run "mvn clean install" to get jar file
#Start a base image with java run time
FROM openjdk:17-jdk-slim

#Information on who maintains the image
MAINTAINER eazybytes.com

# copy jar from local to a jar with name "accounts-0.0.1-SNAPSHOT.jar" in container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# following command instruction is run and we execuate the application without using spring boot
# the following command has same effect as mvn springboot:run
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]

# run the line: docker build . -t(tag) yuduc2(docker user name, which is useful if we are to save our image in remote docker repo)/accounts(name of docker image, we use the name of micro service):s4 (version name/tag name, we use section 4)
# docker run -d(detached mode so terminal is not occupied as docker runs behond the scene) -p(port) 8080(use this port outside of docker to communicate with docker, we can't have 2 contains with same export port in locan system, which is a single network):8080(where my micro services start in docker network, also 8080. Since each containers has saperated network, no issue if we have another container in 8080 as it has saperate network) yuduc2/accounts:s2
# docker run creates new container. We can reuse old comtainer on docker dashboard or
# docker start container id
# docker stop container id
# docker ps see docker process

# port mapping
# docker run -d -p 8081(external port we interact with, this port receive and forward our request to ports in docker container):8080(port in newly instantiated docker container) yuduc2/accounts:s4
# our request ------> local 8081 ---------> container 8080
#                                                 |
# we receive response <-------- local 8081 <----- response from container 8080

# docker run -d -p 8080(external port, cannot be 8081 as external port in local machine is occupied):8080(port in newly instantiated docker container, which can be 8080 as we have a new container isolated from previously generated one) yuduc2/accounts:s4

# Docker Con: 1. writing docker file for big project is complicated -- we need to learn a lot of syntax.. so better use automatical generation