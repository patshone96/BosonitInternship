package com.example.block7crudvalidation.person.service;
import com.example.block7crudvalidation.DateFormatUtil;
import com.example.block7crudvalidation.person.infrastructure.dtos.PersonInputDTO;
import com.example.block7crudvalidation.person.infrastructure.dtos.PersonOutputDTOFull;
import com.example.block7crudvalidation.person.entity.Person;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.person.infrastructure.repository.PersonRepo;
import com.example.block7crudvalidation.Validations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.support.PagedListHolder;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService{

    String order = "id";

    Integer pageNumber;
    Integer pageSize = 10;

    @Autowired
    PersonRepo personRepo;


    //CRITERIA BUILDER EXERCISE

    //DEFINE Entity Manager under the PersistenceContext decorator, not Autowired
    @PersistenceContext
    private EntityManager entityManager;

    //We're returning a list of Person elements. We pass a hashmap as an argument,
    // with a String as identifier of the object
    public List<Person> getCustomQuery(
            HashMap<String, Object> conditions) {

        //We Instantiate a criteria builder using the EntityManager instance
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //Determine which class we're querying
        CriteriaQuery<Person> query = cb.createQuery(Person.class);
        //Establish the root from which we're doing the query
        Root<Person> root = query.from(Person.class);

        //Define a List of elements which will be returned after the query
        List<Predicate> predicates = new ArrayList<>();

        //Switch using the tag field
        conditions.forEach((field, value) -> {
            switch (field) {
                //Return the objects which field values contain a part of the string we look for
                case "name", "surname", "imageUrl":
                    predicates.add(cb.like(root.get(field),
                            "%" + value + "%"));
                    break;
                //Return the objects which field values names are equal to the string we look for
                case "city", "usr":
                    predicates.add(cb.like(root.get(field),
                            (String)   value ));
                    break;

                //Return the objects which dates come after the one we pass
                case "createdDate":

                    predicates.add(cb.greaterThan(root.get(field), DateFormatUtil.format((Date)value)));
                    break;

                // If order is specified, the results will appear ordered by name or usr. By default they're ordered by id
                case "order":
                    if(value.equals("name")){
                        order = "name";
                    }

                    if( value.equals("usr")){
                        order = "usr";
                    }
                    break;


                    //Set the Number of the page we're on, by default its 0, but it's a required param on the controller
                case "pageNumber":
                    pageNumber = (Integer) value;
                    break;

                    //Set the size of the pages, by default it's 10
                case "size":
                    pageSize = (Integer) value;
                    break;



            }
        });

        //Using the root, we order asc by the value of order (i.e. id, name or usr) and then generate an array
        query.select(root)
                .orderBy(cb.asc(root.get(order)))
                .where(predicates.toArray(new Predicate[predicates.size()]));


        //Using the entity manager we generate a List as a result of the query
        List<Person> people = entityManager
                .createQuery(query)
                .getResultList();

        // We use the PagedListHolder class to define pagination
        PagedListHolder<Person> page = new PagedListHolder<Person>(people);
        page.setPageSize(pageSize); // Elements per page
        page.setPage(pageNumber); // Page we're on



        //Finally, return the query paginated
        return page.getPageList();  // Returns the pages


    }



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
