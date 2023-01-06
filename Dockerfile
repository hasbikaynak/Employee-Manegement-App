FROM openjdk:11
EXPOSE 8080
ADD target/ema.jar ema.jar
ENTRYPOINT ["java","-jar","ema.jar"]