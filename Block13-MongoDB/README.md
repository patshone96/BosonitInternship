# MONGODB CRUD using Spring Boot 


## Review
  This project's end is to create a CRUD application using Spring Boot and MongoDB. We use the REST API, Mongo, Web and Lombok dependencies for Maven. 
  The CRUD will function over the entity Person
  
  1. First create a new poject with an hexagonal structure, and the Person entity 
  
  2. Create the Respository interface which extend the MongoRepository<T, ID> interface and which'll provide the necessary methods for the CRUD operations

  3. Create the Input and Output DTOs for the person entity

  4. Create the Person Service Interface which defines the abstract methods that'll be developed on the Service Implementation
  
  5. Create the Person controller. The first endpoint will be for a post request so we can add People to the DB. The method is developed on the Person Service Interface
  
  6. Added a new endpoint to the person controller in order to retrieve people by id. Method developed on the Person Service Interface and in case there isn't a person with the provided id, a 404 error response is returned with a message explaining the situation

  7. Added a new endpoint to the person controller in order to retrieve all people. Method developed on the Person Service Interface. 

 8. Added a delete endpoint to the person controller in order to retrieve people by id. Method developed on the Person Service Interface and in case there isn't a person with the provided id, a 404 error response is returned with a message explaining the situation 

9. Added a modify endtoint to the person controller in order to modify a person. Method developed on the Person Service Interface and in case there isn't a person with the id provided through the input DTO, a 404 error response is returned with a message explaining the situation 
  
  
  
## Testing Endpoints 

https://api.postman.com/collections/24163488-dcc61a27-a544-465f-9f16-090c502a5f4f?access_key=PMAT-01GTVSEVWAT4E8AG4NGWJSXC6T

