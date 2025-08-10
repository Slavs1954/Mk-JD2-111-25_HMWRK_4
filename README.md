# Chat System Emulator

## 🌐 English

This is a small Java project that emulates a simple chat system using **Tomcat** and **PostgreSQL**.

### 🛠 Technologies Used

- Java + Servlet API
- Spring Framework (core DI)
- Apache Tomcat
- PostgreSQL
- Maven (build tool)

### 📂 Project Structure

- Database schema is located in [`src/main/resources/db_create.sql`](src/main/resources/db_create.sql)
- The project is built using Maven
- The result of compilation is a `.war` file, ready to be deployed to a servlet container (e.g., Tomcat)

### 🚀 How to Run

1. Make sure **Maven** is installed and configured.
2. Compile the project:
  ```bash
  mvn clean package
  ```
3. Deploy the generated `target/mvn4-2.0.0-SNAPSHOT.war` to your Tomcat webapps directory.
4. Start Tomcat and access the app in your browser.

## 🇷🇺 Русский

Это небольшой Java-проект, эмулирующий простую чат-систему с использованием **Tomcat** и **PostgreSQL**.

### 🛠 Используемые технологии

- Java + Servlet API
- Spring Framework (core DI)
- Apache Tomcat  
- PostgreSQL  
- Maven (система сборки)

### 📂 Структура проекта

- SQL-скрипт для создания базы данных находится в [`src/main/resources/db_create.sql`](src/main/resources/db_create.sql)  
- Проект собирается с помощью Maven  
- В результате сборки получается `.war`-файл, готовый для развертывания на сервере приложений (например, Tomcat)

### 🚀 Как запустить

1. Убедитесь, что **Maven** установлен и настроен.  
2. Соберите проект:
   ```bash
   mvn clean package
   ```
3. Поместите полученный файл `target/mvn4-2.0.0-SNAPSHOT.war` в папку `webapps` вашего Tomcat-сервера.  
4. Запустите Tomcat и откройте приложение в браузере.
