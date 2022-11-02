package com.example.block5profiles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class profileSelected implements CommandLineRunner {

    //Importamos el valor del profile, el cual será diferente dependiendo del perfil que activemos
    // Si no encuentra la variable profile, el valor por defecto será 'No Active Profile'
    @Value("${profile:No active profiles}")
    private String profile;

    //Importamos el valor bd.url, el cual será diferente dependiendo del perfil que activemos
    // Si no encuentra la variable, el valor por defecto será 'No db url found'
    @Value("${bd.url: No db url found}")
    private String db_url;



    // El método run mostrara en consola los valores del perfil activo y de la bd.url
    @Override
    public void run(String... args) throws Exception {
        System.out.printf("Active profile => %s \n", profile);
        System.out.printf("DB url => %s \n", db_url);

    }
}
