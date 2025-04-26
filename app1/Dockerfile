# 1. Imagen base
FROM openjdk:21-jdk-slim

# 2. Instala Maven
RUN apt-get update && apt-get install -y maven

# 3. Directorio de trabajo
WORKDIR /app

# 4. Copiar proyecto completo al contenedor
COPY . .

# 5. Construir el proyecto (esto genera el JAR en /target)
RUN mvn clean install

# 6. Ejecutar el JAR generado
CMD ["java", "-jar", "target/app1-0.0.1-SNAPSHOT.jar"]
