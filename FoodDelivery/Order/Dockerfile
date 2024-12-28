FROM openjdk:21-jdk-slim
COPY target/order-service.jar order-service.jar
ENTRYPOINT ["java", "-jar", "/order-service.jar"]
EXPOSE 8082