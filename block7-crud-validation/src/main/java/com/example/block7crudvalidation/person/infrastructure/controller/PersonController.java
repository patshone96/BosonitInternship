package com.example.block7crudvalidation.person.infrastructure.controller;
import com.example.block7crudvalidation.person.infrastructure.dtos.PersonInputDTO;
import com.example.block7crudvalidation.person.infrastructure.dtos.PersonOutputDTOFull;
import com.example.block7crudvalidation.person.infrastructure.dtos.PersonOutputDTOSimple;
import com.example.block7crudvalidation.person.service.FeignTeacher;
import com.example.block7crudvalidation.person.entity.Person;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@RestController
//To use any oth the methods, we have to add /person to the path
@RequestMapping()
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    FeignTeacher feignTeacher;

    //FEIGN
    //Request to the 8080 server for a teacher. This can be done from another port, e.g. 8081, prepared on run config
    @GetMapping("teacher/{id}")
    public String getTeacherFeign(@PathVariable Integer id,  @RequestParam(defaultValue = "simple") String outputType) throws EntityNotFoundException{
        //DTOTeacherFull full = new DTOTeacherFull(teacherService.getTeacher(id));
        return feignTeacher.getTeacherByID(id, outputType);
    }



    //Request to a server on another port using restTemplate and Response Entity
//    @GetMapping("/teacher/{id}")
//    public DTOTeacherFull getProfesor(@PathVariable Integer id) throws EntityNotFoundException{
//       ResponseEntity<DTOTeacherFull> full = new RestTemplate().getForEntity("http://localhost:8081/teacher/wideGet/1", DTOTeacherFull.class);
//       if(full.getStatusCode() == HttpStatus.OK){
//           return full.getBody();
//       }else{
//           return null;
//       }
//
//
//    }

    //Endpoint to test CRITERIA BUILDER
    //We can pass different parameters, and only pageNumber is required
    @GetMapping("/criteria")
    public Iterable<Person> findPersonBy(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String usr,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String image,
            @RequestParam(required = false) Date date,
            @RequestParam(required = false) String order,
            @RequestParam Integer pageNumber,
            @RequestParam(required = false) Integer size
            ) {

        //Generate a hashmap in which we determine the parameters by which we're querying
        HashMap<String, Object> data = new HashMap<>();

        if(name != null) data.put("name",name);
        if(surname != null) data.put ("surname", surname);
        if(usr != null) data.put ("usr", usr);
        if(city != null) data.put ("city", city);
        if(image != null) data.put ("imageUrl", image);
        if(date != null) data.put ("createdDate", date);
        if(order != null) data.put ("order", order);
        if(pageNumber != null) data.put ("pageNumber", pageNumber);
        if(size != null) data.put ("size", size);

        //We call for the query method which is defined on the PersonServiceImpl and pass the hasmap as an argument
        return personService.getCustomQuery(data);
    }


    //Post to https://codepen.io/de4imo/pen/VwMRENP
        @CrossOrigin(origins = "https://cdpn.io")
    //POST mapping using /add
    @PostMapping
    //We cast the body of the request and turn it into a Person instance. Then save it using the method addPerson from personServide
    public PersonOutputDTOFull addPerson(@RequestBody PersonInputDTO person) throws UnprocessableEntityException {
        return personService.addPerson(person) ;
    }

    //GET mapping using /get/person_id
    @GetMapping("{id}")
    //Retrieve the value of the path variable, cast it as an integer and use it to get a person from the repository
    public String getById(@PathVariable Integer id,
                          @RequestParam(defaultValue = "simple") String outputType) throws EntityNotFoundException {


        if(outputType.equals("full")){
             PersonOutputDTOFull full = new PersonOutputDTOFull(personService.getPerson(id));
             return full.toString();

        }

        PersonOutputDTOSimple simple = new PersonOutputDTOSimple(personService.getPerson(id));
        return simple.toString();
    }

    //GET mapping using /getAll
    @CrossOrigin(origins = "https://cdpn.io")
    @GetMapping()
    //Return an Iterable<Person> with all the people on the repository
    public ArrayList<PersonOutputDTOFull> getAll(){
        return personService.getAll();
    }

    //GET mapping using /user/user_id
    @GetMapping("/user/{user}")
    //Return an ArrayList with all people with the same user stored on the repository
    public ArrayList<Person> byUser(@PathVariable String user) throws EntityNotFoundException{

        return personService.getUser(user);

    }

    //DELETE mapping of a person by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Integer id) throws EntityNotFoundException {
        personService.deletePerson(id);
        return ResponseEntity.ok().body(String.format("PERSON WITH ID: %d DELETED", id));
    }

    //Handles responses when EntityNotFoundException is thrown
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //Code of the response
    public String entityNotFound(EntityNotFoundException e){
        return e.getMessage(); //Show the message of the exception
    }

    //Handles responses when UnprocessableEntityException is thrown
    @ExceptionHandler(UnprocessableEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) //Code of the response
    public String unprocessableEntity(UnprocessableEntityException u){
        return u.getMessage(); //Show the message of the exception
    }
}
