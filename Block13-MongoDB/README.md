# MONGODB CRUD using Spring Boot 


## Review
  This project's end is to create a CRUD application using Spring Boot and MongoDB. We use the REST API, Mongo, Web and Lombok dependencies for Maven. 
  The CRUD will function over the entity Person
  
  1. First create a new poject with an hexagonal structure, and the Person entity 
  
  2. Create the Respository interface which extend the MongoRepository<T, ID> interface and which'll provide the necessary methods for the CRUD operations

  3. Create the Input and Output DTOs for the person entity

  4. Create the Person Service Interface which defines the abstract methods that'll be developed on the Service Implementation
  
  5. Create the Person controller. The first endpoint will be for a post request so we can add People to the DB. The method is developed on the Person Service Interface
  
  
  


