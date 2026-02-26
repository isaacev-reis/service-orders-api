# Service Orders API 🛠️

A robust REST API for service order management, built with Spring Boot. 
The project uses a state machine to ensure that the service orders workflow is strictly followed.

## 🚀 Tech:

- Java 21
- Spring Boot 3
- Spring Data JPA: for data persistence
- Lombok: to reduce boilerplate code (Getters/Setters)
- UUID: unique and universal identifiers for greater security

## 📋 Business Rules

The API manages the lifecycle of an order through the following states:

- OPEN: Order created and waiting to start
- IN_PROGRESS: The service is being executed
- COMPLETED: Service successfully completed
- CANCELED: Order canceled -> can only occur if it has not been completed

🛣️ Main Endpoints
- POST /orders -> Creates a new order (generates UUID and status OPEN)
- GET /orders -> List all service orders
- GET /orders/{id} -> Get the service order by id (UUID)
- PATCH /orders/start/{id} -> Change the status to IN_PROGRESS
- PATCH /orders/finish/{id} -> Change the status to COMPLETED
- PATCH /orders/cancel/{id} -> Change the status to CANCELED
