package com.example.examen_JPA_cascada;

import com.example.examen_JPA_cascada.CabeceraFra.infrastructure.repository.CabeceraFraRepository;
import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import com.example.examen_JPA_cascada.CabeceraFra.service.CabeceraFraService;
import com.example.examen_JPA_cascada.Cliente.model.Cliente;
import com.example.examen_JPA_cascada.Cliente.service.ClienteService;
import com.example.examen_JPA_cascada.LineasFra.model.LineasFra;
import com.example.examen_JPA_cascada.LineasFra.service.LineasFraService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@Slf4j
public class ExamenJpaCascadaApplication {

	public ExamenJpaCascadaApplication() throws Exception{

	}

	public static void main(String[] args) {
		SpringApplication.run(ExamenJpaCascadaApplication.class, args);

	}

	@Resource(type = DataInsertion.class)
	CommandLineRunner clr;


}






