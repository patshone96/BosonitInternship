package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service
//Launches a different Bean depending on the Path value on the GET request - BeanController
public class BeanService implements beanDefinition {

    @Autowired
    PersonService personService;


    @Bean
    public void Bean1(){
        personService.createPerson("Bean1");

    }

   @Bean
    public void Bean2(){
        personService.createPerson("Bean2");

    }


    @Bean
    public void Bean3(){
        personService.createPerson("Bean3");

    }
}
