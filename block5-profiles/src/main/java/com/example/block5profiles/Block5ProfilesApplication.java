package com.example.block5profiles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.Resource;


@SpringBootApplication
@Slf4j
public class Block5ProfilesApplication {

	// Los perfiles están configurados en la carpeta run

	// Para iniciar la ejecución, simplemente selecciono el perfil (local, pro o int)

	// Para cada perfil he definido la variable spring.profiles.active = (local, pro o int)

	// Estos perfiles acceden a los archivos de propiedades específicos (local, int, pro),
	// En los cuales se han definido valores específicos para las propiedades

	// Si ninguno de los perfiles anteriores está activo, se lee el fichero application.properties
	// En él, el valor de la variable profile es MAIN

	public static void main(String[] args) {
		SpringApplication.run(Block5ProfilesApplication.class, args);

	}

	// Importamos la CLR creada en profileSSelected para que se ejecute al lanzar el main
	@Resource(type = profileSelected.class)
	public CommandLineRunner clr;

}
