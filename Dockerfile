FROM openjdk:8-jdk-alpine
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom","-jar","/app.jar"]
