# BookMyShow Application
A Java-based online movie ticket booking system, inspired by BookMyShow, built using Spring Boot, REST APIs, and a MySQL database. This application allows users to browse movies, view seat availability, and book tickets.

## Features
Booking Module with redis to avoid pessimistic locking


## Tech Stack
- Backend: Java, Spring Boot, Spring Data JPA, Spring Security
- Frontend: React.js / Thymeleaf (if applicable)
- Database: MySQL
- Build Tool: Maven
- Payment Integration: (e.g., Razorpay, Stripe, etc., if implemented)

## Getting Started
### 1. Prerequisites
Ensure you have the following installed:

- Java 17+
- Gradle
- MySQL
- Redis
- Postman (optional, for API testing)

### 2. Clone the Repository
```
git clone https://github.com/SamadSarwar786/bookmyshow
cd bookmyshow
```

### 3. Set Up MySQL Database
- Create a MySQL database:
  
  ```
  CREATE DATABASE bookmyshow;
  ```
- Update the database credentials in application.properties: 
```
spring.datasource.url=jdbc:mysql://localhost:3306/bookmyshow
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
```

### 4. Setup the redis server
- Start the redis server in terminal
```
redis-server
```

### 5. Run the Application
- Build the application:
```
mvn clean install
```
- Run the application:
```
mvn spring-boot:run
```

