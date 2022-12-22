FROM openjdk:19-alpine
EXPOSE 8000
WORKDIR /app
ADD target/rent-0.0.1-SNAPSHOT.jar rent-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","rent-0.0.1-SNAPSHOT.jar"]