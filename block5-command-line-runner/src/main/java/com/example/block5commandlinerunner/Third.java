package com.example.block5commandlinerunner;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Component
public class Third implements CommandLineRunner {



    public void imprimeParametros(String... args){
        List<String> al = Arrays.asList(args);

        Stream<String> stream = al.stream();

        stream.forEach(System.out::println);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Soy la tercera clase");




    }
}
