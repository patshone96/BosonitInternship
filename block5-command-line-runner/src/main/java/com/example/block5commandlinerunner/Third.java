package com.example.block5commandlinerunner;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
@Component
public class Third implements CommandLineRunner {


    //Para poder cargar valores, se tiene que modificar el archivo application.properties, añadiendo los valores
    @Value("${project.name}")
    private String nombreProyecto;

    @Value("${participants}")
    private String[] participants;

    // Ahora podemos usar los valores cargados dentro del método run()
    // Este nos va a decir que estamos en la tercera clase y sacara los valores cargados
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Soy la tercera clase");
        System.out.println("Este es el proyecto"+nombreProyecto);
        System.out.println("Los participantes son: ");
        Stream<String> stream = Arrays.asList(participants).stream();
        stream.forEach(System.out::println);


    }
}
