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

## 👩‍💻 Author

Sanika Naringe
