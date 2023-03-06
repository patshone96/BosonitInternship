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

	//Inject the three services we're using to insert data after the app is running
	@Autowired
	ClienteService clienteService;

	@Autowired
	CabeceraFraService cabeceraFraService;

	@Autowired
	LineasFraService lineasFraService;


	public static void main(String[] args) {
		SpringApplication.run(ExamenJpaCascadaApplication.class, args);

	}

	//Insert data after the app starts
	@PostConstruct
	public void addEntry(){

		//We're creating a Client, a CabeceraFra and 2 LineasFra to insert into de DB
		Cliente cli = new Cliente();
		CabeceraFra cab= new CabeceraFra();
		LineasFra lineasFra = new LineasFra();
		LineasFra lineasFra2 = new LineasFra();

		//Set the client name
		cli.setName("Patrick");
		//Then save it using the clientService class
		Cliente cli1 = clienteService.addCliente(cli);

		//Set the CabeceraFra attributes
		cab.setClient(cli1);
		cab.setImporteFra(10);

		//Set the first Line attributes
		lineasFra.setProdName("Caracoles");
		lineasFra.setPrice(5);
		lineasFra.setQuantity(2);

		//Set the second Line attributes

		lineasFra2.setProdName("Cerezas");
		lineasFra2.setPrice(1);
		lineasFra2.setQuantity(2);

		//Save the lines using the lineasFraService and storing the result in a List lines
		List<LineasFra> lineas = new ArrayList<>();
		lineas.add(lineasFraService.addLineas(lineasFra));
		lineas.add(lineasFraService.addLineas(lineasFra2));

		//Set the CabeceraFra Lines using the lineas List
		cab.setLineasFra(lineas);

		//Save the CabeceraFra using the Service ...
		cabeceraFraService.addCabecera(cab);

	}

}






