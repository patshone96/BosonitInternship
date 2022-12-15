package com.example.block7crudvalidation.student.infrastructure.controller;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.person.service.PersonService;
import com.example.block7crudvalidation.student.application.StudentService;
import com.example.block7crudvalidation.student.infrastructure.dtos.DTOStudentFull;
import com.example.block7crudvalidation.student.infrastructure.dtos.DTOStudentSimple;
import com.example.block7crudvalidation.student.entity.Student;
import com.example.block7crudvalidation.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    PersonService personService;

    @Autowired
    TeacherService teacherService;



    @PostMapping("add")
    public Student addStudent(@RequestBody Student  student,
                              @RequestParam Integer id_person, //
                                @RequestParam Integer id_teacher) throws EntityNotFoundException {

        student.setTeacher(teacherService.getTeacher(id_teacher));
        student.setPerson(personService.getPerson(id_person));

        return studentService.addStudent(student);

    }

    //Remove a person from the REPO by ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) throws EntityNotFoundException {

        try{ //If the ID exists
            studentService.deleteStudent(id);
            return ResponseEntity.ok().body(String.format( "STUDENT WITH ID: %d DELETED", id));

        }catch(Exception e){ //If the ID does not exist we throw an exception
            throw new EntityNotFoundException();

        }

    }

    @GetMapping("get/{id}")
    //If the ID does not exist in the REPO, a PersonNotFoundException will be thrown
    public String getStudentById(@PathVariable Integer id,
                                 @RequestParam(defaultValue = "simple") String outputType ) throws EntityNotFoundException{

        if(outputType.equals("full")){ //if outputType param is full

            DTOStudentFull full = new DTOStudentFull(studentService.getStudent(id));
            return  full.toString();

        }else{ //By default response
            DTOStudentSimple simple = new DTOStudentSimple(studentService.getStudent(id));
            return simple.toString();
        }



    }


    @GetMapping("getAll")
    //Returns an Iterable object with containing all the people on the Repo
    public Iterable<Student> getAll(){

        return studentService.getAll();
    }


    @PutMapping("change/{id}")
    //Tries to change an entry. If the entry (id) does not exist, this throws a PersonNotFoundException
    //If there is any empty field, a EmptyFieldException is thrown
    public Student changePerson(@RequestBody Student student,
                               @PathVariable Integer id) throws EntityNotFoundException, UnprocessableEntityException {

        return studentService.modifyStudent(student, id);

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
