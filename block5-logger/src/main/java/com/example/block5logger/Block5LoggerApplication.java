package com.example.block5logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5LoggerApplication {

	//Para que el programa realice su función (menajes log por consola excepto error, que se guarda en un .log
	// Tenemos que configurar un archivo logback.xml en resources --> src/main/resources/logback.xml.

	public static void main(String[] args) {
		SpringApplication.run(Block5LoggerApplication.class, args);
	}

}
