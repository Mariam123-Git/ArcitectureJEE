# --- Étape 1 : build de l'application ---
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app
COPY . .

RUN chmod +x gradlew
RUN ./gradlew clean build -x test
RUN ls -la /app/build/libs/

# --- Étape 2 : image Tomcat ---
FROM tomcat:10.1.48-jdk21

RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /app/build/libs/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]



