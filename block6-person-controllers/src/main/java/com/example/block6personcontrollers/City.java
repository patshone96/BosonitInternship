package com.example.block6personcontrollers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
    private String name;
    private int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }


}
