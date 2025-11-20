FROM maven:latest
LABEL authors='auri'

WORKDIR /app
COPY pom.xml /app
COPY . /app
RUN mvn package
CMD ["java", "-jar", "target/SonarCalculator.jar"]