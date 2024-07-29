FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /wallets-app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM tomcat:9.0-jdk11
COPY --from=build /wallets-app/target/wallets-app-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/