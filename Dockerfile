FROM openjdk:13-alpine3.9

ENV APP_VERSION LOCAL
ENV APPLICATION_NAME=fibonacci_api
EXPOSE 80

ADD build/install/ /
CMD ["/FibonacciAPI-boot/bin/FibonacciAPI"]
