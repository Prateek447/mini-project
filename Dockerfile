FROM openjdk:8
EXPOSE 8081
ADD target/assessment.jar assessment.jar
ENTRYPOINT ["java", "-jar","assessment.jar"]