FROM openjdk:8
EXPOSE 8080
RUN mkdir report-api
WORKDIR /report-api/
ADD /target/report-api-0.0.1.jar /report-api/report-api-0.0.1.jar
ENTRYPOINT ["java","-jar", "report-api-0.0.1.jar"]
