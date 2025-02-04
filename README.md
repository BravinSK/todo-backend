ToDo Application Backend  

This is a Spring Boot backend for a simple ToDo application. It provides RESTful APIs to manage tasks, allowing users to create, update, delete, and retrieve tasks. The backend is built using Java, Spring Boot, and PostgreSQL as the database.  

Features  

- Create a new ToDo task  
- Retrieve all ToDo tasks  
- Retrieve a single task by ID  
- Update an existing task  
- Mark tasks as complete or incomplete  
- Delete a task  

Tech Stack  

- Spring Boot - Backend framework  
- Spring Data JPA - ORM for database interactions  
- PostgreSQL - Database  
- ModelMapper - DTO mapping  
- Lombok - Reduces boilerplate code  
- Spring Web - REST API support  

Setup & Installation  

Clone the Repository  
```  
git clone https://github.com/your-username/todo-backend.git  
cd todo-backend  
```  

Configure the Database  
Ensure you have PostgreSQL installed and update the `application.properties` file with your database credentials:  
```  
spring.datasource.url=jdbc:postgresql://localhost:5432/todo  
spring.datasource.username=your_db_username  
spring.datasource.password=your_db_password  
```  

Build and Run the Application  
Using Maven, you can build and run the application with:  
```  
mvn spring-boot:run  
```  
By default, the application runs on port 8081.  

API Endpoints  

GET `/api/todos` - Get all ToDos  
GET `/api/todos/{id}` - Get ToDo by ID  
POST `/api/todos` - Create a new ToDo  
PUT `/api/todos/{id}` - Update a ToDo  
DELETE `/api/todos/{id}` - Delete a ToDo  
PUT `/api/todos/markComplete/{id}` - Mark task as complete  
PUT `/api/todos/markIncomplete/{id}` - Mark task as incomplete  

Future Improvements  

- Add user authentication  
- Implement due dates for tasks  
- Add priority levels for tasks  
