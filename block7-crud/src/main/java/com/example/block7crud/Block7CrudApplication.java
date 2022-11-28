package com.example.block7crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block7CrudApplication {
	//Postman collection to try the functionalities of this appliation
	//https://www.getpostman.com/collections/ab79cae09020bb8022e2

	//Web to try the h2 database
	//http://localhost:8080/h2-console/
	//Driver Class: org.h2.Driver
	//JDBC URL: jdbc:h2:~/ejerciciosJPA
	//User Name: sa
	//Password :
	public static void main(String[] args) {
		SpringApplication.run(Block7CrudApplication.class, args);
	}

}
