# FX Deals Importer
A Spring Boot application that imports FX deals, validates them, and stores them in PostgreSQL.
The system supports REST APIs, CSV file upload, pagination, and global exception handling.
## Technologies
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Apache Commons CSV
- Postman
## How to Run
## I run it like this, you else: in the file directory >: "C:\Program Files\NetBeans-23\netbeans\java\maven\bin\mvn.cmd" spring-boot:run
1. Start PostgreSQL using Docker:
```bash
docker compose up -d
mvn spring-boot:run

### 5️⃣ API Endpoints
```md
## API Endpoints

### Create FX Deal
POST /api/v1/fx-deals

### Get All Deals
GET /api/v1/fx-deals

### Get Deals with Pagination
GET /api/v1/fx-deals/paged

### Upload CSV File
POST /api/v1/fx-deals/upload


## CSV File Format

Columns:
- dealId
- fromCurrency
- toCurrency
- amount
- dealTimestamp

Example:
FX-101,USD,EUR,1000,2026-01-02T13:30:00
