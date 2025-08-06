# Etapa 1: Build
FROM maven:3.9.5-eclipse-temurin-21 AS builder

WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: Run
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY --from=builder /build/target/market-0.0.1-SNAPSHOT.jar /app/market.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/market.jar"]
