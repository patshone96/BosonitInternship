package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Person {

    String name, town = "unknown";
    int age = 0;


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

    static String lectura() throws IOException {

        String output = "";

        String path  = "C:/Users/patrick.oliver/Desktop/people.csv";

        FileReader fr = new FileReader(path);

        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();

        while (line != null){
            output += line+"\n";
            line = br.readLine();
        }

        br.close();

        return output;










    }


}
