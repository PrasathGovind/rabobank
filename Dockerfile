FROM openjdk:8-jdk-alpine
ARG JAR_FILE=payments-0.0.1-SNAPSHOT.jar
COPY /root/.m2/repository/com/rabobank/payments/0.0.1-SNAPSHOT/payments-0.0.1-SNAPSHOT.jar ${JAR_FILE}
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
