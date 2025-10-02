# Complaints Management System (Spring Boot)

A simple complaints management web application built with Spring Boot, Spring Data JPA, Thymeleaf, and MySQL. Users can create, view, update, and delete complaint records via a web UI.

Note: The project package/class names are based on a Student Management template; complaints are persisted using the `Student` JPA entity (mapped to table `complaints`) and exposed via complaint-oriented routes and views.

## Tech Stack
- Java 17
- Spring Boot 3.x
  - Web, Thymeleaf, Data JPA
- MySQL 8 (JDBC driver: `mysql-connector-j`)
- Maven

## Features
- Create, list, edit, and delete complaint records
- Server-side rendering using Thymeleaf templates
- JPA with MySQL persistence
- Health check endpoint

## Project Structure
```
complaints-system/
├─ pom.xml
├─ src/main/java/net/javaguides/sms/
│  ├─ StudentManagementSystemApplication.java  # Spring Boot entrypoint
│  ├─ controller/
│  │  ├─ ComplaintController.java             # CRUD endpoints for complaints
│  │  └─ StudentController.java               # Home redirect + health
│  ├─ entity/
│  │  └─ Student.java                         # JPA entity mapped to `complaints` table
│  ├─ model/
│  │  └─ Complaint.java                       # Plain model (not persisted)
│  ├─ repository/
│  │  └─ StudentRepository.java               # Spring Data JPA repository
│  ├─ service/
│  │  ├─ StudentService.java
│  │  ├─ ComplaintService.java                # Interface (in-memory helper optional)
│  │  └─ impl/
│  │     ├─ StudentServiceImpl.java
│  │     └─ InMemoryComplaintService.java     # Optional in-memory store
│  └─ store/
│     └─ ComplaintStore.java                  # In-memory store component
└─ src/main/resources/
   ├─ application.properties                   # DB/JPA/Server config
   └─ templates/
      ├─ complaints.html
      ├─ create_student.html                   # used for create complaint form
      ├─ edit_student.html                     # used for edit complaint form
      └─ students.html                         # legacy template
```

## Data Model
Complaints are stored using the `Student` entity (`src/main/java/net/javaguides/sms/entity/Student.java`) mapped to table `complaints` with fields:
- `id` (Long, PK, auto-generated)
- `registrationNumber` (String, required)
- `name` (String, required)
- `department` (String)
- `hostelInfo` (String)
- `category` (String)
- `description` (String, length 1000)
- `date` (LocalDateTime)
- `status` (String)

## Endpoints
- `GET /` → Redirects to `/complaints` (`StudentController.home()`)
- `GET /health` → "Application is running!" (`StudentController.health()`)
- `GET /complaints` → List complaints (`ComplaintController.listComplaints()`)
- `GET /complaints/new` → Create form (`ComplaintController.createComplaintForm()`)
- `POST /complaints` → Persist new complaint (`ComplaintController.saveComplaint()`)
- `GET /complaints/edit/{id}` → Edit form (`ComplaintController.editComplaintForm()`)
- `POST /complaints/{id}` → Update complaint (`ComplaintController.updateComplaint()`)
- `GET /complaints/{id}` → Delete by id (`ComplaintController.deleteComplaint()`)

Note: Form templates use names from the original student template: `create_student.html`, `edit_student.html`.

## Prerequisites
- JDK 17 installed and `JAVA_HOME` set
- Maven 3.8+ installed
- MySQL 8 running locally

## Configuration
Set your database credentials in `src/main/resources/application.properties`:
```
# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/shyam
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

# Server Configuration
server.port=8080

# Thymeleaf Configuration
spring.thymeleaf.cache=false
```
- Make sure the database `shyam` exists, or change the URL to a database you created.
- `spring.jpa.hibernate.ddl-auto=update` will create/update the `complaints` table.

## Run the App
Using Maven (from project root):
```
mvn spring-boot:run
```
Or build a jar and run:
```
mvn clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```
The app will be available at `http://localhost:8080`.

## Usage
- Go to `http://localhost:8080/complaints` to view the complaints list.
- Click "New" (or relevant button in the UI) to add a complaint.
- Use edit/delete actions from the list to update or remove items.

## Development Notes
- Entry point: `StudentManagementSystemApplication`.
- The `ComplaintController` delegates persistence to `StudentService`, which uses `StudentRepository` (Spring Data JPA) to operate on the `complaints` table.
- Dates and statuses are defaulted if not supplied when saving/updating.

## Troubleshooting
- Port already in use: change `server.port` in `application.properties`.
- MySQL auth errors: verify username/password and DB name; ensure MySQL is running.
- Schema issues: delete the table or switch to a fresh DB and start with `ddl-auto=update`.
- Timezone warnings: consider adding `?serverTimezone=UTC` to the JDBC URL if needed.

## Build Info
- Parent: `org.springframework.boot:spring-boot-starter-parent:3.5.6`
- Dependencies: Web, Thymeleaf, Data JPA, MySQL driver, Test starter.

## License
This project is for educational/demonstration purposes. Add a license if you intend to distribute.
