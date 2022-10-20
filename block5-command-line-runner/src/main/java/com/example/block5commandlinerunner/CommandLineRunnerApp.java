package com.example.block5commandlinerunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@SpringBootApplication
@Slf4j
public class CommandLineRunnerApp {


	public CommandLineRunnerApp() throws Exception {
	}


	public static void main(String[] args) {
		SpringApplication.run(CommandLineRunnerApp.class, args);

	}
	//Anotamos con PostConstruct el método primerMensaje
	// Aparece incluso antes de que se haya lanzado completamente el programa
	@PostConstruct
	public void imprimir(){
		System.out.println("Soy la primera clase");
	}

	//Inyectamos las clases 2 y 3 que implementan la interfaz CLR
	@Resource(type = Second.class)
	public CommandLineRunner clr1;

	@Resource(type = Third.class)
	public CommandLineRunner clr2;


}
