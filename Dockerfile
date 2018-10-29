FROM anapsix/alpine-java
MAINTAINER henriquelemos0@gmail.com
COPY ./build/libs/*.jar /home/results.jar
COPY ./src/test/resources/fullResults.log /home/results.log
CMD ["java","-jar","/home/results.jar", "/home/results.log"]