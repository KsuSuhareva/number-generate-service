FROM openjdk:17-jdk-alpine
COPY target/*.jar number-generate-service.jar
EXPOSE 7070
ENTRYPOINT ["java","-jar","number-generate-service.jar"]