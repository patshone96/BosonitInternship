package com.example.block6pathvariableheaders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//El servidor se lanza en el puerto 8081 (se puede cambiar en application.properties)
// por tanto los request se realizan en localhost:8081
@SpringBootApplication
public class Block6PathVariableHeadersApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block6PathVariableHeadersApplication.class, args);
	}

}
