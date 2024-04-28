FROM openjdk:17
EXPOSE 8080
WORKDIR /app

ARG ARTIFACTORY_USERNAME
ARG ARTIFACTORY_PASSWORD

RUN curl -u $ARTIFACTORY_USERNAME:$ARTIFACTORY_PASSWORD -o basic-java-project-0.0.1-SNAPSHOT.jar "http://192.168.56.103:8082/artifactory/java-nagarro-assignment/binaries/basic-java-project-0.0.1-SNAPSHOT.jar"

ENTRYPOINT ["java", "-jar", "basic-java-project-0.0.1-SNAPSHOT.jar"]
