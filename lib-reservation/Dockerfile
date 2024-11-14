
# Use the OpenJDK 17 image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR file (after building the app) to the container
COPY target/reservation-0.0.1-SNAPSHOT.jar app.jar

# Expose the port
EXPOSE 8081

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
ENV MYSQL_HOST=mysql-container