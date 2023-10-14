# Todo List API

This is a simple Java project built with Spring Boot that serves as a Todo List API. It uses PostgreSQL as the database to store and manage tasks.

## Table of Contents

- [Todo List API](#todo-list-api)
  - [Table of Contents](#table-of-contents)
  - [Prerequisites](#prerequisites)
  - [Getting Started](#getting-started)
    - [Clone the Repository](#clone-the-repository)
    - [Database Configuration](#database-configuration)
    - [Build and Run](#build-and-run)
  - [Usage](#usage)
  - [API Endpoints Implemented](#api-endpoints-implemented)
  - [License](#license)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) - This project uses Java, so make sure you have JDK 8 or higher installed.
- [Spring Boot](https://spring.io/projects/spring-boot) - The project is built with Spring Boot, which simplifies the development of production-ready applications.
- [PostgreSQL](https://www.postgresql.org/) - You need to have a PostgreSQL database instance to store the Todo List data.
- [Maven](https://maven.apache.org/) - This project uses Maven as the build tool.

## Getting Started

### Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/carlossgabriel/Java-SB-todo-list.git
```

### Database Configuration

You need to set up your PostgreSQL database and configure the application properties. Open the `src/main/resources/application.properties` file and modify the database connection details:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_list
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Build and Run

Build the project using Maven:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## Usage

You can use this API to manage your Todo List tasks. You can interact with the API using various HTTP requests, such as GET, POST, PUT, and DELETE.

## API Endpoints Implemented

- Tasks
- [x] **Create a new task**: `POST /tasks/create`
- [ ] **List all tasks**: `GET /tasks`
- [ ] **Get a task by ID**: `GET /tasks/{taskId}`
- [ ] **Update a task**: `PUT /tasks/{taskId}`
- [ ] **Delete a task**: `DELETE /tasks/{taskId}`

- Users
- [x] **Create a new user**: `POST /user/create`
- [ ] **List all users**: `GET /users`
- [ ] **Get a user by ID**: `GET /users/{userId}`
- [ ] **Update a user**: `PUT /users/{userId}`
- [ ] **Delete a user**: `DELETE /users/{userId}`


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.