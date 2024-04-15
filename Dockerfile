# Use the official OpenJDK 11 image as the base image
FROM openjdk:11

# Set the working directory in the container
WORKDIR /app

# Copy the packaged WAR file into the container at /app
COPY target/tullave-cl.war /app

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the WAR file when the container launches
CMD ["java", "-jar", "tullave-cl.war"]