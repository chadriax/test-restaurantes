# Usar una imagen base de OpenJDK 21
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo pom.xml para resolver dependencias de Maven
COPY app1/pom.xml /app/

# Copiar el código fuente
COPY app1/src /app/src

# Copiar el archivo generado .jar (si ya tienes el .jar compilado en /target)
COPY app1/target/app1-0.0.1-SNAPSHOT.jar /app/app1-0.0.1-SNAPSHOT.jar

# Comando para construir la aplicación con Maven y ejecutarla
RUN mvn clean install

# Comando para ejecutar la aplicación .jar
CMD ["java", "-jar", "app1-0.0.1-SNAPSHOT.jar"]
