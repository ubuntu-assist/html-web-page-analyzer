FROM openjdk:17-alpine
WORKDIR /app
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
EXPOSE 8080
CMD ["java", "-jar", "demo.jar"]



