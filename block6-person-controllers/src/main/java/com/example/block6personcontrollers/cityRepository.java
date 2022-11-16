package com.example.block6personcontrollers;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
//Stores the different cities, created before and during the program's life
public class cityRepository {
    public  List<City> cities =  new ArrayList<>();

     public void addCity(City c){
        cities.add(c);
    }

     public List<City> getCities(){
        return cities;
    }
}
