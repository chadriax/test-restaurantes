# Usar una imagen base de OpenJDK 21
FROM openjdk:21-jdk-slim

# Exponer el puerto 8080 (ajustar según sea necesario si usas otro puerto)
EXPOSE 8080

# Comando para construir la aplicación con Maven y ejecutarla
RUN mvn clean install

# Comando para ejecutar la aplicación .jar
CMD ["java", "-jar", "app1-0.0.1-SNAPSHOT.jar"]
