FROM openjdk:8
EXPOSE 8080
RUN mkdir report-api
WORKDIR /report-api/
ADD /target/api-seas-1.0.0-SNAPSHOT.jar /report-api/report-api.jar
ENTRYPOINT ["java","-jar", "report-api.jar"]
