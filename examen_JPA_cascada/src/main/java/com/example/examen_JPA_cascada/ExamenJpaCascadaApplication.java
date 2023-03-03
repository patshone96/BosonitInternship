package com.example.examen_JPA_cascada;

import com.example.examen_JPA_cascada.CabeceraFra.infrastructure.repository.CabeceraFraRepository;
import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import com.example.examen_JPA_cascada.CabeceraFra.service.CabeceraFraService;
import com.example.examen_JPA_cascada.Cliente.model.Cliente;
import com.example.examen_JPA_cascada.Cliente.service.ClienteService;
import com.example.examen_JPA_cascada.LineasFra.model.LineasFra;
import com.example.examen_JPA_cascada.LineasFra.service.LineasFraService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ExamenJpaCascadaApplication {

	@Autowired
	ClienteService clienteService;

	@Autowired
	CabeceraFraService cabeceraFraService;

	@Autowired
	LineasFraService lineasFraService;




	public static void main(String[] args) {
		SpringApplication.run(ExamenJpaCascadaApplication.class, args);

	}

	@PostConstruct
	public void addEntry(){

		Cliente cli = new Cliente();
		CabeceraFra cab= new CabeceraFra();
		LineasFra lineasFra = new LineasFra();
		LineasFra lineasFra2 = new LineasFra();

		cli.setName("Patrick");

			Cliente cli1 = clienteService.addCliente(cli);

		cab.setClient(cli1);
		cab.setImporteFra(10);

		lineasFra.setProdName("Caracoles");
		lineasFra.setPrice(5);
		lineasFra.setQuantity(2);



		lineasFra2.setProdName("Cerezas");
		lineasFra2.setPrice(1);
		lineasFra2.setQuantity(2);

		//lineasFra2.setCabeceraFra(cf1);

		lineasFra = lineasFraService.addLineas(lineasFra);
		lineasFra2 = lineasFraService.addLineas(lineasFra2);

		List<LineasFra> lineas = new ArrayList<>();
		lineas.add(lineasFra2);
		lineas.add(lineasFra);

		cab.setLineasFra(lineas);

		cabeceraFraService.addCabecera(cab);


	}






}






