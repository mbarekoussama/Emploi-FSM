# Multi-stage build for Spring Boot application

# Stage 1: Build the application using Maven wrapper
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /app

# Copy Maven wrapper and make it executable
COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .
RUN chmod +x mvnw

# Copy the pom.xml
COPY pom.xml .

# Copy the source code
COPY src ./src

# Build the application
# Note: If you encounter SSL certificate issues in your environment,
# you may need to build locally and use a simpler Dockerfile
RUN ./mvnw clean package -DskipTests || \
    (apt-get update && apt-get install -y ca-certificates && \
    update-ca-certificates && \
    ./mvnw clean package -DskipTests)

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8082

# Run the application
Comment viewENTRYPOINT ["java", "-jar", "app.jar"]
