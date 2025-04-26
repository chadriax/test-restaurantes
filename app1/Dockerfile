# 1. Imagen base
FROM openjdk:21-jdk-slim

# 2. Instalar Maven
RUN apt-get update && apt-get install -y maven

# 3. Crear carpeta de trabajo
WORKDIR /app

# 4. Copiar el contenido del proyecto
COPY . .

# 5. Construir el proyecto (esto genera el JAR en /target)
RUN mvn clean install

# 6. Ejecutar el JAR generado
CMD ["java", "-jar", "target/tu-jar-generado.jar"]
