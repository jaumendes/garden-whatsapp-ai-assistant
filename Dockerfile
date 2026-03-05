FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/garden-bot.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
