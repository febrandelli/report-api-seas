FROM openjdk:8
EXPOSE 8080
RUN mkdir report-api
WORKDIR /report-api/
ADD /target/api-seas-0.0.1-SNAPSHOT.jar /report-api/report-api.jar
ENTRYPOINT ["java","-jar", "report-api.jar"]
