package com.example.block5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Block5PropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block5PropertiesApplication.class, args);
	}

	//Importamos los valores de applications.properties con la anotación @Value

	@Value("${greeting}")
	private String greeting;

	@Value("${my.number}")
	private int myNumber;

	// Como new.property no existe en el fichero applications.properties usamos la notación
	// "popiedad:valorPorDefecto" para que no salte un error

	@Value("${new.property:No existe esta propiedad}")
	private String nuevaPropiedad;

	// En el Bean guardamos la función mostrar que se ejecutará al ejecutar el programa
	@Bean
	public void mostrar(){
		System.out.println("El valor de greeting es: " + greeting);
		System.out.println("El valor de my.number es: " + myNumber);
		System.out.println("El valor de new.property es: " + nuevaPropiedad);
	}


}
