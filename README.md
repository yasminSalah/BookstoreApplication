# Online Bookstore Management System

The Online Bookstore Management System is a Spring Boot application that provides functionalities for managing books, inventory, users, and borrowing operations.

## Features

- Users can browse through available books, view book details, and request to borrow a book.
- Administrators can manage the inventory by adding or deleting books, updating book details, and managing stock levels and availability.
- Bonus feature: Implements a recommendation system that suggests related books based on a customer's browsing and borrowing history.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- MySQL Database
- Maven

### Installation

1. Clone the repository:

git clone (https://github.com/yasminSalah/BookstoreApplication.git)

2. Create a MySQL database and update the database configuration in `src/main/resources/application.properties` file:

spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
spring.datasource.username=your-username
spring.datasource.password=your-password

3. Build the project using Maven: 
cd bookstore
mvn clean install

4. Run the application:
java -jar target/bookstore-1.0.0.jar

5. Access the application using the following URL:

http://localhost:8080


## API Endpoints

### Books

- GET /books: Get all books
- GET /books/{id}: Get book by ID
- POST /books: Add a new book
- PUT /books/{id}: Update book details
- DELETE /books/{id}: Delete a book

### Inventory

- PUT /inventory/{bookId}/stock-level: Update stock level for a book
- PUT /inventory/{bookId}/availability: Set book availability

### Users

- GET /users: Get all users
- GET /users/{id}: Get user by ID
- POST /users: Add a new user
- PUT /users/{id}: Update user details
- DELETE /users/{id}: Delete a user

### Borrowing

- POST /borrow/{bookId}: Borrow a book
- PUT /return/{borrowingId}: Return a book

## Contributing

Contributions are welcome! Please feel free to submit a pull request.
