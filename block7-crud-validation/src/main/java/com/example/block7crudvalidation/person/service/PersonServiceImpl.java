package com.example.block7crudvalidation.person.service;
import com.example.block7crudvalidation.person.Infrastructure.dtos.PersonInputDTO;
import com.example.block7crudvalidation.person.Infrastructure.dtos.PersonOutputDTOFull;
import com.example.block7crudvalidation.person.entity.Person;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.person.Infrastructure.repository.PersonRepo;
import com.example.block7crudvalidation.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepo personRepo;

    @Override
    //Get a person by id
    public Person getPerson(Integer id) throws EntityNotFoundException {
        //Try to find a person with a given id on the PersonRepo
        Optional opc = personRepo.findById(id);


        if(opc.isEmpty()){ //If there isn't one, an exception is thrown
           throw new EntityNotFoundException();
        }else{ // If there is this person, we return it
            Person person = (Person) opc.get();

            return person;
        }
    }

    @Override
    //Try to find all people with the same username
    public ArrayList<Person> getUser(String user) throws EntityNotFoundException{
        if(personRepo.findPersonByName(user).isEmpty()){ //If there isn't anyone, we throw an exception
            throw new EntityNotFoundException();
        }else{ // We return a List of people which share the same username
            return personRepo.findPersonByName(user);
        }

    }

    @Override
    // We return a Iterable element with all people saved on the repository
    public Iterable<Person> getAll(){
        return personRepo.findAll();
    }

    @Override
    //We add a person to the repo
    public PersonOutputDTOFull addPerson(PersonInputDTO personDTO) throws UnprocessableEntityException {

        //Validate using the Validations class methods. If the validation fails, an exception is thrown
        if(
                        !Validations.validate_user(personDTO.getUsr())
                        || !Validations.validate_str_notNull(personDTO.getName())
                        || !Validations.validate_str_notNull(personDTO.getPassword())
                        || !Validations.validate_str_notNull(personDTO.getCity())
                        || !Validations.validate_str_notNull(personDTO.getCompanyMail())
                                || !Validations.validate_str_notNull(personDTO.getPersonalMail())
                ||!Validations.validate_date(personDTO.getCreatedDate())
        ){
            throw new UnprocessableEntityException();
        }
        // We save the person on the repo and return it

         Person p = new Person();

        p.setPerson_id(personDTO.getPerson_id());
        p.setName(personDTO.getName());
        p.setUsr(personDTO.getUsr());
        p.setPassword(personDTO.getPassword());
        p.setSurname(personDTO.getSurname());
        p.setCity(personDTO.getCity());
        p.setCompanyMail(personDTO.getCompanyMail());
        p.setPersonalMail(personDTO.getPersonalMail());
        p.setActive(personDTO.getActive());
       p.setCreatedDate(personDTO.getCreatedDate());
       p.setImageUrl(personDTO.getImageUrl());
       p.setTerminationDate(personDTO.getTerminationDate());


        return new PersonOutputDTOFull(personRepo.save(p));


    }

    @Override
    //Delete a person by id or throw an error if it does not exist on the repo
    public void deletePerson(Integer id) throws EntityNotFoundException {
        if(personRepo.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        personRepo.deleteById(id);
    }
}
