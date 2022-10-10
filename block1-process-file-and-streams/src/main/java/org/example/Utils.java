package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Utils {

    // Método para leer un fichero con personas y devolver una colección de personas
    public static List<Person> lectura() throws IOException {

        List<Person> personas = new ArrayList<>();

        String path  = "../block1-process-file-and-streams/src/main/java/org/example/people.csv";

        FileReader fr = new FileReader(path);

        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();

        while (line != null){
            String[] datos = line.split(":");

            switch (datos.length){
                case 1:
                    personas.add(new Person(datos[0]));
                    break;
                case 2:
                    Pattern pattern = Pattern.compile("[0-9]+");
                    Matcher matcher = pattern.matcher(datos[1]);

                    if (matcher.find()){
                        personas.add(new Person(datos[0], Integer.parseInt(datos[1])));

                    }else{
                        personas.add(new Person(datos[0], datos[1]));
                    }
                    break;

                case 3 :
                    personas.add(new Person(datos[0], datos[1], Integer.parseInt(datos[2])));
                    break;
                default:
                    System.out.println("Error en los datos al añadir una persona");

            }

            line = br.readLine();

        }

        br.close();

        return personas;

    }

    // Método para que al recibir una colección de personas, nos devuelva otra con las menores de 25
    public static List<Person> menores25(List<Person> pers){

        List<Person> salida= new ArrayList<>();

        Stream<Person> stream = pers.stream();

       stream.filter(p -> p.age<25 && p.age>0)
                .forEach(salida::add);


        return salida;
    }

    // Método para que al recibir una colección de personas, nos devuelva otra con las que no empiezan por A
    public static List<Person> sinAinicial(List<Person> pers){
        List<Person> sinA = new ArrayList<>();

        Stream<Person> st = pers.stream();

        st.filter(s -> s.name.matches("^[^A]"))
                .forEach(sinA::add);

        return sinA;

    }

    // Método para leer streams de personas e imprimirlos por pantalla
    public static void leerStream(Stream<Person> st){
        st.forEach(s -> System.out.println(s.toString()));


    }



}
