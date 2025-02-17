# **REST API FOR CONTACT MANAGEMENT**

## **Project Description**
This is a REST API developed in Java with Spring Boot to manage the registration of People and their Contacts. The API allows performing CRUD operations on both entities.

## **Features**

### **Person:**
- **Create Person:** POST `/api/people`
- **Get Person by ID:** GET `/api/people/{id}`
- **Get Person for Direct Mail:** GET `/api/people/mailing/{id}`
- **List All People:** GET `/api/people`
- **Update Person:** PUT `/api/people/{id}`
- **Delete Person:** DELETE `/api/people/{id}`

### **Contact:**
- **Add Contact:** POST `/api/contacts/`
- **Get Contact by ID:** GET `/api/contacts/{id}`
- **List All Contacts of a Person:** GET `/api/contacts/person/{idPerson}`
- **Update Contact:** PUT `/api/contacts/{id}`
- **Delete Contact:** DELETE `/api/contacts/{id}`

## **Technologies Used**
- **Java 21**
- **Spring Boot 3.4.2**
- **Spring Data JPA (Hibernate)**
- **Database: H2**
- **Swagger OpenAPI for Documentation**

## **Installation and Execution**

### **1. Clone the Repository**
```
git clone https://github.com/yourusername/yourrepository.git
cd yourrepository
```

### **2. Configure the Database**
By default, the application is configured to use an in-memory H2 database. If needed, update the `application.properties` file with the following settings:
```
spring.datasource.url=jdbc:h2:mem:contacts
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### **3. Run the Application**
```
mvn spring-boot:run
```
The API will be available at: **http://localhost:8082**

## **API Documentation (Swagger)**
The API documentation can be accessed at:
- **Swagger UI:** http://localhost:8082/swagger-ui.html

## **Running Automated Tests**
To run the tests:
```
mvn test
```

