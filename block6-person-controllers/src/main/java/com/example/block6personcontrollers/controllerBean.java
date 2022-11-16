package com.example.block6personcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controller/bean")
public class controllerBean {


    @Autowired
    PersonService personService;

    @Autowired
    BeanService Bean;


    //We map the Path variable {bean} so the response uses a differrent bean deppending on the variable bean
    @GetMapping(value="/{bean}")
        public ResponseEntity<Person> beanPerson(@PathVariable(value = "bean", required = false) String bean){

        switch (bean){
            case "Bean1": Bean.Bean1(); break;
            case "Bean2": Bean.Bean2();break;
            case "Bean3": Bean.Bean3();break;
            default:
                personService.createPerson("Error al elegir el bean");

        }


        return ResponseEntity.ok().body(personService.getPerson());



    }

}
