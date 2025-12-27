# ---------------------------------------------------------
# ETAPA 1: CONSTRUCCIÓN (BUILD) 🏗️
# Usamos una imagen que tiene Maven y Java instalados
# ---------------------------------------------------------
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder

# Creamos una carpeta de trabajo
WORKDIR /app

# Copiamos el archivo pom.xml y descargamos las librerías
# (Esto se hace aparte para que sea más rápido si no cambias las dependencias)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos todo el código fuente (src)
COPY src ./src

# Compilamos y empaquetamos (creamos el .jar) saltándonos los tests para ir rápido
RUN mvn clean package -DskipTests

# ---------------------------------------------------------
# ETAPA 2: EJECUCIÓN (RUN) 🏃
# Usamos una imagen ligera solo con Java para correr la app
# ---------------------------------------------------------
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copiamos SOLO el archivo .jar creado en la etapa anterior (builder)
COPY --from=builder /app/target/*.jar app.jar

# Abrimos el puerto 8080
EXPOSE 8080

# Arrancamos la app
ENTRYPOINT ["java", "-jar", "app.jar"]