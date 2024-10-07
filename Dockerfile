#FROM e para declarar o sistema operacional -eclipse-turin e uma imagem para aplicacao java
#e uma imagem oficial com a openJDK
FROM eclipse-temurin:21-alpine
#LABEL e para indicar o autor
LABEL authors="eduardo"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/api-irrigacao-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]