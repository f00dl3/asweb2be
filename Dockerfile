FROM eclipse-temurin:17
WORKDIR /app
COPY build/libs/*SNAPSHOT.war /app
EXPOSE 8082
CMD ["java", "-jar", "backend-SNAPSHOT.jar" ]
