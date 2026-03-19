# 🎓 Student Management System

A clean and scalable **Spring Boot REST API** for managing student data with CRUD operations, validation, and pagination.

---

## 🚀 Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Swagger UI

---

## 📌 Features

* CRUD operations
* Validation using `@Valid`
* Global Exception Handling
* Pagination & Sorting
* Search API
* DTO Pattern
* Logging

---

## 🏗️ Architecture

This project follows a layered architecture:

Controller → Service → Repository → Database

- Controller: Handles HTTP requests and responses  
- Service: Contains business logic  
- Repository: Interacts with database using JPA  
- DTO: Transfers data between layers

---

## 📂 API Endpoints

**Students**

* `GET /api/v1/students`
* `GET /api/v1/students/{id}`
* `POST /api/v1/students`
* `PUT /api/v1/students/{id}`
* `DELETE /api/v1/students/{id}`

**Pagination**

* `GET /api/v1/students/page?page=0&size=5&sortBy=id&sortOrder=asc`

**Search**

* `GET /api/v1/students/search?name=abc&email=xyz`

---

## 📖 API Docs

http://localhost:8080/swagger-ui/index.html

---

## 📸 Screenshots

### 🔹 Swagger UI
![Swagger UI](https://github.com/user-attachments/assets/0bce7730-8727-4eb5-897f-a4f7031fb53e)

### 🔹 Postman Response
![Postman](https://github.com/user-attachments/assets/fbb0ee42-73ec-4f60-ac57-ad6348908f2e)


## 👩‍💻 Author

Sanika Naringe
