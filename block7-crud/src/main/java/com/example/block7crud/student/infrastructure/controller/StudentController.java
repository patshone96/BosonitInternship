package com.example.block7crud.student.infrastructure.controller;


import com.example.block7crud.exceptions.EmptyFieldsException;
import com.example.block7crud.exceptions.PersonNotFoundException;
import com.example.block7crud.student.entity.Student;
import com.example.block7crud.student.application.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    //Post mapping of a person:
    //{
    //"name":"Maria",
    //"surname":"Castro",
    //"city": "Valencia"
    //}
    @PostMapping("add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);

    }

    //Remove a person from the REPO by ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){

        try{ //If the ID exists
            studentService.deleteStudent(id);
            return ResponseEntity.ok().body(String.format( "STUDENT WITH ID: %d DELETED", id));

        }catch(Exception e){ //If the ID does not exist we throw an exception
            throw new PersonNotFoundException("Student not found");

        }




    }

    @GetMapping("get/{id}")
    //If the ID does not exist in the REPO, a PersonNotFoundException will be thrown
    public Student getPersonById(@PathVariable Integer id) throws PersonNotFoundException{

        return studentService.getStudent(id);

    }


//    @GetMapping("get/name/{name}")
//    public ArrayList<Student > getPersonByName(@PathVariable String name) throws PersonNotFoundException{
//
//        //If there is no student with the given name, a PersonNotFoundException is thrown,
//        // else a list of students is returned
//        if(studentService.getStudent(name).isEmpty()){throw new PersonNotFoundException("Student not found");};
//
//        return studentService.getStudent(name);
//
//    }

    @GetMapping("getAll")
    //Returns an Iterable object with containing all the people on the Repo
    public Iterable<Student> getAll(){

        return studentService.getAll();

    }



    @PutMapping("change/{id}")
    //Tries to change an entry. If the entry (id) does not exist, this throws a PersonNotFoundException
    //If there is any empty field, a EmptyFieldException is thrown
    public Student changePerson(@RequestBody Student student,
                               @PathVariable Integer id) throws PersonNotFoundException, EmptyFieldsException {

        return studentService.modifyStudent(student, id);

    }



    //This method handles PersonNotFoundException returning a 404 code
    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<String> personNotFound(){
        return ResponseEntity.notFound().build();


    }

    //This method handled EmptyFieldException returning a BadRequest code
    @ExceptionHandler(EmptyFieldsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> emptyFields(){
        return ResponseEntity.badRequest().build();


    }
    
}
