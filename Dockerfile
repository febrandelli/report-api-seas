FROM openjdk:8
EXPOSE 8080

RUN mkdir report-api
WORKDIR /report-api/

RUN apt-get update
RUN apt-get install -y maven

ADD pom.xml /report-api/pom.xml
RUN ["mvn", "dependency:resolve"]

# Adding source, compile and package into a fat jar
ADD src /report-api/src
RUN ["mvn", "package"]

ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
