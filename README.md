# Employee Management System

A comprehensive Spring Boot REST API application for managing employees, departments and projects with MySQL database integration.

## 🚀 Features

- **Department Management**: Create, read, update and delete departments
- **Employee Management**: Manage employee records with department associations
- **Project Management**: Handle project assignments and employee-project relationships
- **RESTful API**: Clean REST endpoints for all operations
- **Database Integration**: MySQL database with JPA/Hibernate
- **Data Relationships**: 
  - One-to-Many: Department to Employees
  - Many-to-Many: Employees to Projects

## 🛠️ Tech Stack

- **Backend**: Spring Boot 3.5.0
- **Database**: MySQL
- **ORM**: Spring Data JPA / Hibernate
- **Build Tool**: Maven
- **Java Version**: 17

## 📋 Prerequisites

- Java 17 or higher
- MySQL 8.0 or higher
- Maven 3.6+ (or use included Maven wrapper)

## ⚙️ Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/employee-management-system.git
cd employee-management-system/system
```

### 2. Database Setup
Create a MySQL database:
```sql
CREATE DATABASE systemdb;
```

### 3. Configure Database
Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/systemdb
spring.datasource.username=root
spring.datasource.password=
```

### 4. Run the Application
Using Maven wrapper:
```bash
./mvnw spring-boot:run
```

Or using Maven:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 📡 API Endpoints

### Department Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/department` | Get all departments |
| GET | `/department/{id}` | Get department by ID |
| POST | `/department` | Create new department |
| PUT | `/department/{id}` | Update department |
| DELETE | `/department/{id}` | Delete department |

### Sample Department JSON
```json
{
  "id": 1,
  "name": "Engineering",
  "established": "2020-01-15"
}
```

## 📊 Database Schema

### Tables
- **Department**: Stores department information
- **Employee**: Employee records extending Person entity
- **Project**: Project information
- **Person**: Base entity for common person attributes
- **project_assignments**: Junction table for employee-project relationships

### Entity Relationships
```
Department (1) ←→ (*) Employee (*) ←→ (*) Project
```

## 🔧 Configuration

### Application Properties
```properties
spring.application.name=system
spring.datasource.url=jdbc:mysql://localhost:3306/systemdb
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create
```

## 📸 Screenshots

![Screenshot 2025-06-08 233222](https://github.com/user-attachments/assets/4012daec-6eef-43d1-9ea3-6ae6d1ce10ee)
![Screenshot 2025-06-08 233241](https://github.com/user-attachments/assets/a2fc462a-4089-45a8-8a5e-6dba9ca1c39d)
![Screenshot 2025-06-08 233429](https://github.com/user-attachments/assets/e8325ed2-7906-4b6b-bffd-d7654bb90315)
![Screenshot 2025-06-08 233632](https://github.com/user-attachments/assets/17ea4844-7625-4d06-9db0-32618178a808)
![Screenshot 2025-06-08 233916](https://github.com/user-attachments/assets/7cde9d0e-b65f-46a4-9171-392ad9e23f27)
