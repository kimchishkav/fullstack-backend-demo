FROM eclipse-temurin:17-jdk

WORKDIR /app

# Копируем всё приложение в образ
COPY . .

# Собираем Spring Boot проект через Gradle (без тестов)
RUN ./gradlew build -x test

# Какой порт будет слушать контейнер
EXPOSE 8080

# Запускаем приложение
CMD ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]