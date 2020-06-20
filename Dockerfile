FROM openjdk:8-jdk-alpine
ARG JAR_FILE=initiate-payments-0.0.1-SNAPSHOT.jar
COPY /root/.m2/repository/com/rabobank/initiate-payments/0.0.1-SNAPSHOT/initiate-payments-0.0.1-SNAPSHOT.jar ${JAR_FILE}
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
