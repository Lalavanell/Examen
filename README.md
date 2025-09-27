## Requisitos
- Java 17+
- Maven 3.8+
- Node.js 20.19.1
- Angular CLI 18

# 1. Subir backend desde la carpeta backend
./mvnw spring-boot:run

# 2. Instalar Angular CLI (versión 18)
npm install -g @angular/cli@18

# 3. Instalar Node.js (versión 20.19.1)
Asegúrate de tener la versión correcta usando nvm o descargándola desde nodejs.org

# Script que use para crear la tabla:
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    picture_large VARCHAR(255),
    city VARCHAR(100),
    email VARCHAR(150),
    first_name VARCHAR(100),
    gender VARCHAR(20),
    last_name VARCHAR(100),
    name_title VARCHAR(50),
    phone VARCHAR(50),
    postcode INTEGER,
    state VARCHAR(100)
);
