#!/bin/bash

# Clean and build the Spring application
mvn package -DskipTests

# Build the Docker image
docker build -t sushi-app .