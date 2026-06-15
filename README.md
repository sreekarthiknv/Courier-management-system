# Courier Management System

A RESTful API built with Spring Boot for managing courier shipments. Supports creating shipments, tracking by ID, listing all couriers, and updating delivery status.

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17 |
| Framework | Spring Boot 4.0.2 |
| Persistence | Spring Data JPA + Hibernate |
| Database | H2 (in-memory) |
| Build Tool | Maven |

---

## Project Structure

```
src/main/java/com/firstproject/couriermanagement/
├── Controller/
│   └── CourierController.java    # REST endpoints
├── model/
│   └── Courier.java              # JPA entity
├── repository/
│   └── CourierRepository.java    # Data access layer
├── service/
│   └── CourierService.java       # Business logic
└── CourierManagementApplication.java
```

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+

### Run the Application

```bash
git clone https://github.com/your-username/courier-management-system.git
cd courier-management-system
./mvnw spring-boot:run
```

The server starts at `http://localhost:8080`.

> **H2 Console:** Access the in-memory database UI at `http://localhost:8080/h2-console`  
> JDBC URL: `jdbc:h2:mem:courierdb` | Username: `sa` | Password: *(leave blank)*

---

## API Endpoints

Base URL: `/api/couriers`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/couriers` | Create a new courier shipment |
| `GET` | `/api/couriers` | Get all couriers |
| `GET` | `/api/couriers/{id}` | Get courier by ID |
| `PUT` | `/api/couriers/{id}/status?status=` | Update shipment status |

---

## Sample Requests

### Create a Courier
```http
POST /api/couriers
Content-Type: application/json

{
  "senderName": "Karthik",
  "receiverName": "Rahul",
  "source": "Coimbatore",
  "destination": "Bangalore",
  "status": "PENDING"
}
```

### Get All Couriers
```http
GET /api/couriers
```

### Get by ID
```http
GET /api/couriers/1
```

### Update Status
```http
PUT /api/couriers/1/status?status=DELIVERED
```

---

## Courier Entity Fields

| Field | Type | Description |
|-------|------|-------------|
| `id` | Long | Auto-generated primary key |
| `senderName` | String | Name of the sender |
| `receiverName` | String | Name of the receiver |
| `source` | String | Origin city/location |
| `destination` | String | Destination city/location |
| `status` | String | Shipment status (e.g., PENDING, IN_TRANSIT, DELIVERED) |

---

## Notes

- Data is stored **in-memory** and resets on every application restart (`ddl-auto=create-drop`).
- To persist data, replace the H2 dependency with MySQL/PostgreSQL and update `application.properties` accordingly.
- API tested with Postman.

---

## Author

**Sreekarthik**  
B.Tech Information Technology — KGISL Institute of Technology  
[LinkedIn](https://linkedin.com/in/your-profile) | [GitHub](https://github.com/your-username)
