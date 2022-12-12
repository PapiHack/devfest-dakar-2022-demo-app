FROM maven:3-jdk-11 as MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM amazoncorretto:11-alpine

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
