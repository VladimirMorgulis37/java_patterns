FROM ubuntu:latest
LABEL authors="randomcat17"

ENTRYPOINT ["top", "-b"]
FROM openjdk:19-jdk-alpine
COPY ninethwork2-1.0-SNAPSHOT.jar ninethwork2-1.0-SNAPSHOT.jar
CMD ["java","-jar","ninethwork2-1.0-SNAPSHOT.jar"]