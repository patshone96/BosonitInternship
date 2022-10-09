package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Person {

    String name, town = "unknown";
    int age = 0;

    List<Person> p = new ArrayList<>();


    public Person(String name, String town, int age){
        this.name = name;
        this.town = town;
        this.age = age;


    }

    public Person(String name){
        this.name = name;
    }

    public Person(String name, String town){
        this.name = name;
        this.town = town;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {

        if(this.age == 0){
            return "Name: " + this.name + " Town: " + this.town + " Age: " + "unknown";

        }

        if(this.town.equals("")){
            return "Name: " + this.name + " Town: " + "unknown" + " Age: " +  this.age;

        }

        if(this.age == 0 && this.town.equals("")){
            return "Name: " + this.name + " Town: " + "unknown" + " Age: " + "unknown";

        }

        return "Name: " + this.name + " Town: " + this.town + " Age: " + this.age ;
    }
}
