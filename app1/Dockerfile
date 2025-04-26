# 1. Imagen base
FROM openjdk:21-jdk-slim

# 2. Instala Maven
RUN apt-get update && apt-get install -y maven

# 3. Directorio de trabajo
WORKDIR /app

# 4. Copiar todo el proyecto
COPY . .

# 5. Cambiar al subdirectorio donde está el pom.xml
WORKDIR /app/app1

# 6. Construir el proyecto
RUN mvn clean install

# 7. Ejecutar el JAR
CMD ["java", "-jar", "target/app1-0.0.1-SNAPSHOT.jar"]
