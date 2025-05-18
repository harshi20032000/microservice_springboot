# Monolith Reservation App v1

A monolithic Spring Boot application designed for managing reservations. This backend service is built using Spring Boot, PostgreSQL, and Maven, adhering to RESTful principles.

---

## 📦 Project Overview

This project serves as the backend layer for a reservation management system. It provides APIs to perform CRUD operations on reservation entities and ensures data validation, persistence, and structured error handling.

---

## 🧰 Tech Stack

- **Java 17** – Modern features and performance.
- **Spring Boot 2.6.6** – Simplifies backend development with pre-configured components.
- **Maven** – Dependency management and build tool.
- **PostgreSQL** – Open-source relational database.
- **JUnit 5** – Unit testing framework.

---

## 📦 Dependencies & Why They’re Used

| Dependency                            | Purpose                                                                 |
|--------------------------------------|-------------------------------------------------------------------------|
| `spring-boot-starter-web`            | To build RESTful web services using Spring MVC and embedded Tomcat.    |
| `spring-boot-starter-data-jpa`       | Simplifies database interactions using Spring Data JPA with Hibernate. |
| `spring-boot-starter-validation`     | Enables bean validation (e.g. `@NotNull`, `@Email`) using Hibernate Validator. |
| `postgresql` (runtime)               | JDBC driver to connect the Spring Boot app with a PostgreSQL database. |
| `spring-boot-starter-test` (test)    | Provides testing support including JUnit, Mockito, and Spring Test.    |

---

## ⚙️ Prerequisites

Before running the application, make sure you have:

- Java 17 installed
- Maven installed
- PostgreSQL running locally or remotely

---
