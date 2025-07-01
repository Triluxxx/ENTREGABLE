# Usamos una imagen base oficial de OpenJDK (Java 17 o 20 por ejemplo)
FROM openjdk:17-slim
# Directorio dentro del contenedor donde estará la app
WORKDIR /app
# Copiamos el archivo jar generado a la carpeta /app en el contenedor
COPY target/lab-clinico-0.0.1-SNAPSHOT.jar app.jar
# Exponemos el puerto 8080 para la app Spring Boot
EXPOSE 8080
# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
