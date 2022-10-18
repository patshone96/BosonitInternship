package com.example.block5commandlinerunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@SpringBootApplication
@Slf4j
public class CLRApp {


	public CLRApp() throws Exception {
	}

	public static void main(String[] args) {
		SpringApplication.run(CLRApp.class, args);


	}

	@PostConstruct
	public void imprimir(){
		System.out.println("Soy la primera clase");
	}

	@Resource(type = Second.class)
	public CommandLineRunner clr1;

	@Resource(type = Third.class)
	public CommandLineRunner clr2;


}
