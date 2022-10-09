package org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;




public class Main {



    public static void main(String[] args) throws IOException {


        List<Person> listaPersonas = Utils.lectura();


        System.out.println("Lista completa de personas: \n");
        Stream<Person> stream = listaPersonas.stream();

        Utils.leerStream(stream);

        System.out.println("\n Menores de 25 \n");

        List<Person> menores25 = Utils.menores25(listaPersonas);

        Stream<Person> stream25 = menores25.stream();

        Utils.leerStream(stream25);

        System.out.println("\n Nombres que no empiezan por A \n");

        List<Person> sinA = Utils.sinAinicial(listaPersonas);

        Stream<Person> streamSinA = sinA.stream();

        Utils.leerStream(streamSinA);






    }
}