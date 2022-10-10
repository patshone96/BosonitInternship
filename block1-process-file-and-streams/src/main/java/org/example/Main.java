package org.example;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static org.example.Utils.*;


public class Main {



    public static void main(String[] args) throws IOException {


        // Guardamos las personas leídas con lectura() en una lista de personas
        List<Person> listaPersonas = lectura();


        // Parte 1. imprimimos la lista de personas leída
        System.out.println("Lista completa de personas: \n");
        Stream<Person> stream = listaPersonas.stream();
        leerStream(stream);

        //Parte 2. Generamos una lista de menores de 25 a partir de la anterior y la mostramos

        System.out.println("\n Menores de 25 \n");

        List<Person> menores25 = menores25(listaPersonas);

        Stream<Person> stream25 = menores25.stream();

        leerStream(stream25);

        //Parte 3. Buscamos en la lista primera -listaCompleta- a las personas que no empiezan por A

        System.out.println("\n Nombres que no empiezan por A \n");

        List<Person> sinA = sinAinicial(listaPersonas);

        Stream<Person> streamSinA = sinA.stream();

        leerStream(streamSinA);

        //Parte 4. De las personas menores de 25, buscamos a la primera que viva en Madrid y la primera que viva en BCN

        System.out.println("\n Primera persona menor de 25 que vive en Madrid");

        Optional<Person> p = deDonde(menores25, "Madrid");

        p.ifPresentOrElse(s -> System.out.println(s.toString()), () -> System.out.println("No hay nadie de Madrid"));


        System.out.println("\n Primera persona menor de 25 que vive en Barcelona");

        Optional<Person> p2 = deDonde(menores25, "Barcelona");

        p2.ifPresentOrElse(s -> System.out.println(s.toString()), () -> System.out.println("No hay nadie de Barcelona"));

    }
}