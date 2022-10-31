package com.example.block5logger;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class restController {

        // En este controlador importamos la classe logger y creamos una instancia para poder usar el log
        Logger logger = LoggerFactory.getLogger(restController.class);

        //Mediante Request Mapping creamos un método que escribirá en el log cuando accedamos a la dirección
        @RequestMapping("/")
        public String index() { //Definimos distintos mensajes a distintos niveles
            logger.trace("Mensaje a nivel de TRACE");
            logger.debug("Mensaje a nivel de DEBUG");
            logger.info("Mensaje a nivel de INFO");
            logger.warn("Mensaje a nivel de WARNING");
            logger.error("Mensaje a nivel de ERROR");

            return "Hola! Mira los logs para ver los resultados"; // Esto se mostrará en la dirección del buscador
        }
    }

