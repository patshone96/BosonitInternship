package org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.example.Person.lectura;


public class Main {



    public static void main(String[] args) throws IOException {

        List<Person> personas = new ArrayList<>();

        personas.add(new Person("ANA"));
        personas.add(new Person("ANA", "SEVILLA"));
        personas.add(new Person("ANA", 23));
        personas.add(new Person("ANA", "SEVILLA", 23));

        Stream<Person> stream = personas.stream();

        stream.forEach(p -> System.out.println(p.name+":"+p.town+":"+p.age));

        String lect = lectura();

        String[] porLineas = lect.split("\n");

        /*for(String i: porLineas){
            System.out.println(i);
        }*/

        List<String> listaPersonas = new ArrayList<>();

        Collections.addAll(listaPersonas, porLineas);

        for(String i: listaPersonas){
            System.out.println(i);
        }













    }
}