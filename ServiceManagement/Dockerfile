# Stage 1: Build stage
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run stage
FROM openjdk:17.0.1-jdk-slim

# Copy JAR file
COPY --from=build /target/ServiceManagement-0.0.1-SNAPSHOT.jar app.jar

# Copy the SQLite database file
COPY --from=build /Test.sqlite ./Test.sqlite

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
