# Автосалон: Управление автомобилями

Проект представляет собой REST API для управления автомобилями в автосалоне. Он позволяет добавлять, получать, обновлять и удалять автомобили, а также предоставляет базовую информацию о доступных автомобилях.

## Функциональность

- **Добавление автомобиля**: Добавление нового автомобиля в базу данных.
- **Получение списка автомобилей**: Получение списка всех доступных автомобилей.
- **Получение автомобиля по ID**: Получение информации о конкретном автомобиле по его идентификатору.
- **Обновление автомобиля**: Обновление информации об автомобиле по его идентификатору.
- **Удаление автомобиля**: Удаление автомобиля из базы данных по его идентификатору.
- **Приветственное сообщение**: Простое приветственное сообщение для проверки работы API.

## Технологии

- **Java 17**: Основной язык программирования.
- **Spring Boot**: Фреймворк для создания REST API.
- **Maven**: Управление зависимостями и сборка проекта.
- **Checkstyle**: Проверка стиля кода.
- **Javadoc**: Документирование кода.

## Запуск проекта

### Требования

- Установленная Java 17 или выше.
- Установленный Maven.

### Инструкция по запуску

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/KrychyX/java_lab.git

2. Перейдите в директорию проекта:
   ```bash
   cd java_lab
   
3. Соберите проект с помощью Maven:
  ```bash
   mvn clean install

4. Запустите проект:
   ```bash
   mvn spring-boot:run

5. После запуска API будет доступен по адресу:
   ```bash
   http://localhost:8080

---

### **Примеры запросов**
```markdown
## Примеры запросов

### Добавление автомобиля
**Запрос:**
```bash
POST /cars
Content-Type: application/json
{
  "mark": "Toyota",
  "speed": 200,
  "year": 2022
}
Ответ:
HTTP Status: 201 Created

### Получение списка автомобилей
**Запрос:**
```bash
GET /cars
Ответ:
[
  {
    "id": 1,
    "mark": "Toyota",
    "speed": 200,
    "year": 2022
  },
  {
    "id": 2,
    "mark": "Honda",
    "speed": 180,
    "year": 2021
  }
]

### Получение автомобиля по ID
**Запрос:**
```bash
GET /cars/1
Ответ:
{
  "id": 1,
  "mark": "Toyota",
  "speed": 200,
  "year": 2022
}

### Обновление автомобиля
**Запрос:**
```bash
PUT /cars/1
Content-Type: application/json

{
  "mark": "Toyota",
  "speed": 220,
  "year": 2023
}
Ответ:
HTTP Status: 200 OK

### Удаление автомобиля
**Запрос:**
```bash
DELETE /cars/1
Ответ:
HTTP Status: 200 OK

---

### **Возможные улучшения**
```markdown
## Возможные улучшения

1. **Добавление базы данных**: Использование базы данных (например, PostgreSQL или MySQL) для хранения данных об автомобилях.
2. **Аутентификация и авторизация**: Добавление системы безопасности (например, Spring Security) для защиты API.
3. **Логирование**: Добавление логирования для отслеживания операций и ошибок.
4. **Документация API**: Использование Swagger для автоматической генерации документации API.
5. **Контейнеризация**: Создание Docker-образа для удобного развертывания приложения.

## Автор

Кирилл  
kryk.97325@gmail.com
