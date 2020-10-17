# Fibonacci API
## Description
RESTful application which computes the fibonacci number for an input number.

## Requirements
* `openjdk-11-jdk`
* `docker`

## Build and run tests
Use the following gradle tasks to build and run the tests of the application:
* `gradle clean build`
* `gradle test`

## Deployment
The application can be built for distribution using the following command:
* `gradle clean installBootDist`

Now we can build a Docker image and run it:
* `docker build -t bahia/fibonacci .`
* `docker run -it -d --name fibonacci -p 8081:8080 bahia/fibonacci`

The application is now running and exposed to our host machine at port 8081 and we can access the Swagger page at http://localhost:8081. 
