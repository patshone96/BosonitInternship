package com.example.block7crudvalidation.person.service;
import com.example.block7crudvalidation.person.infrastructure.dtos.PersonInputDTO;
import com.example.block7crudvalidation.person.infrastructure.dtos.PersonOutputDTOFull;
import com.example.block7crudvalidation.person.entity.Person;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.person.infrastructure.repository.PersonRepo;
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
    public ArrayList<PersonOutputDTOFull> getAll(){

        ArrayList<PersonOutputDTOFull> output = new ArrayList<>();

        Iterable<Person> iter = personRepo.findAll();

        iter.forEach(p -> output.add(new PersonOutputDTOFull(p)));


        return output;
    }

    @Override
    //We add a person to the repo
    public PersonOutputDTOFull addPerson(PersonInputDTO personDTO) throws UnprocessableEntityException {

        //Validate using the Validations class methods. If the validation fails, an exception is thrown
        if(
                        !Validations.validate_user(personDTO.getUsuario())
                        || !Validations.validate_str_notNull(personDTO.getName())
                        || !Validations.validate_str_notNull(personDTO.getPassword())
                        || !Validations.validate_str_notNull(personDTO.getCity())
                        || !Validations.validate_str_notNull(personDTO.getPersonal_email())
                                || !Validations.validate_str_notNull(personDTO.getCompany_email())
                //||!Validations.validate_date(personDTO.getCreatedDate())
        ){
            throw new UnprocessableEntityException();
        }
        // We save the person on the repo and return it

         Person p = new Person();

        p.setPerson_id(personDTO.getPerson_id());
        p.setName(personDTO.getName());
        p.setUsr(personDTO.getUsuario());
        p.setPassword(personDTO.getPassword());
        p.setSurname(personDTO.getSurname());
        p.setCity(personDTO.getCity());
        p.setCompanyMail(personDTO.getCompany_email());
        p.setPersonalMail(personDTO.getPersonal_email());
        p.setActive(personDTO.getActive());
       p.setCreatedDate(personDTO.getCreated_date());
       p.setImageUrl(personDTO.getImagen_url());
       p.setTerminationDate(personDTO.getTermination_date());


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
