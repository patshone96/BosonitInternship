package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
//Creates new cities at launch
public class cityGenerator {

   @Autowired
    cityRepository cityRepo;

   public cityGenerator(){
   }

   @Bean
    public void addCities(){
       cityRepo.addCity(new City("Valencia", 15000000));
       cityRepo.addCity(new City("Madrid", 45000000));
       cityRepo.addCity(new City("Barcelona", 50000000));
       cityRepo.addCity(new City("Bilbao", 40000000));

   }








}
