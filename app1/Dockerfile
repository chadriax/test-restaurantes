FROM openjdk:21-jdk-slim

# Instalar Maven
RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY ./app1/pom.xml ./pom.xml
COPY ./app1/src ./src

RUN mvn clean install

EXPOSE 8080

CMD ["java", "-jar", "target/app1-0.0.1-SNAPSHOT.jar"]