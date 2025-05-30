

# ✅ `README.md` – Task Management REST API

````markdown
# 🗂️ Task Management REST API

This project is a **Task Management RESTful API** built with **Spring Boot** and **MySQL**, containerized using **Docker**. 
It provides endpoints to create, read, update, and delete (CRUD) tasks. The API is documented with Swagger UI.



## 📦 Features
```
- Spring Boot 3 (Java 21)
- RESTful API using Spring MVC
- MySQL 8 as the database
- JPA/Hibernate for persistence
- Docker & Docker Compose for containerization
- Swagger/OpenAPI for interactive documentation
- Layered architecture (Controller, Service, Repository, DTO)

```


## 🚀 Getting Started

### 📁 Prerequisites

- Java 21+
- Maven
- Docker & Docker Compose

---

### ⚙️ Running Locally (Dev)

1. **Build the application**

```bash
mvn clean install -DskipTests

````

2. **Start containers**

```bash
docker-compose up --build
```

3. **Access the API**

* API Base URL: `http://localhost:8080/tasks`
* Swagger UI: `http://localhost:8080/swagger-ui.html`

---

## 📬 API Endpoints

| Method | Endpoint      | Description             |
| ------ | ------------- | ----------------------- |
| GET    | `/tasks`      | Get all tasks           |
| GET    | `/tasks/{id}` | Get a specific task     |
| POST   | `/tasks`      | Create a new task       |
| PUT    | `/tasks/{id}` | Update an existing task |
| DELETE | `/tasks/{id}` | Delete a task           |

---

## 🧪 Example Task JSON

```json
{
  "title": "Finish Docker setup",
  "description": "Add Dockerfile and docker-compose to project",
  "status": "IN_PROGRESS"
}
```

---

## 🧰 Technologies Used

* Java 21
* Spring Boot 3.x
* Spring Data JPA
* MySQL 8
* Docker / Docker Compose
* Swagger (Springdoc OpenAPI)

---

## 📁 Project Structure

```
├── controller      # REST Controllers
├── dto             # Data Transfer Objects
├── model           # JPA Entities
├── repository      # Spring Data Repositories
├── service         # Business Logic Layer
├── config          # Swagger & App Config
└── resources
    └── application.properties
```

---

## 🐳 Dockerized Setup

* MySQL container (`mysql-db`) with volume persistence
* Spring Boot API container (`task-api`)
* `SPRING_DATASOURCE_URL` uses container name for internal networking

---

## ✅ Healthcheck

Docker Compose includes a healthcheck for MySQL to ensure Spring Boot waits until DB is ready.

---

## 📄 License

This project is for educational and demonstration purposes.

---

## 🙋‍♂️ Author

Richmond Kwame Nyarko — *CloudNova Inc. Backend Lab Exercise*

```

