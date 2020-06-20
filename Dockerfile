FROM openjdk:8-jdk-alpine
ARG JAR_FILE=initiate-payments-0.0.1-SNAPSHOT.jar
WORKDIR /root/.m2/repository/com/rabobank/initiate-payments/0.0.1-SNAPSHOT
COPY /root/.m2/repository/com/rabobank/initiate-payments/0.0.1-SNAPSHOT/initiate-payments-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","initiate-payments-0.0.1-SNAPSHOT.jar"]
