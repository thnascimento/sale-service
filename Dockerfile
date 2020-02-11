FROM openjdk:11
COPY ./build/libs/ /app
ENTRYPOINT ["java","-jar","/app/sale-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080:8080
WORKDIR /app
