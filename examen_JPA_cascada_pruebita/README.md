# JPA EXAM 

 ## Review 
 
 This is a Java Spring Boot application, using Maven as project manager and using JPA, REST API, H2 database and Lombock dependencies.
 
 
 1. First, the project structure was created, defining folders for the three entities that'd be stored in the h2 database (Cliente, Cabecera and Lineas). A forth folder was created to contain a general controller and a OutputDTO called Factura
 
 2. Then, a POJO was created and stored in the model folder (one for each entity)
 
 3. Following this step, the JPA repository was created, then the service interface and finally the service implementation (again, one for each of the three entities to store in the DB)
 
 4. To continue, the database was configured defining the necessary properties in the application.properties file, setting the spring.jpa.hibernate.ddl-auto property to create-drop 
 
 5. After this, a @PostConstruct decorator was used on the main class to initialize a method that stores data on the DB each time the app is restarted.
 
 6. Next, the REST controller was created and in it three enpoints were defined:
      * Show all Facturas
      * Delete a Factura and all its lines
      * Add Lines to a factura given its ID 

7. DTOs for input and output data were defined and ajusted to the requirements of the task 

8. The app was tested using Postman and H2 console, comments were added and the code was polished 

## POSTMAN ENDPOINTS TO TEST THE APP 
 - https://api.postman.com/collections/24163488-574d7654-5429-4c0a-84c9-4443b1da9307?access_key=PMAT-01GTKXPZ3ZA4DF7ZD3MF8W1C29

## DATABASE TO CHECK THE RESULTS 
 - http://localhost:8080/h2-console/

   + Saved Settings: Generic(H2) Embedded
   + Settngs Name: Generic H2 (Embedded)

   + Driver Class:org.h2.Driver
   + JDBC URL: jdbc:h2:~/JPA
   + User Name: sa
   + Password: 
   
