package com.example.Springtutotrialhelloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // Función que escribe en la página principal deñ servidor
    @RequestMapping
    public String HelloWorld(){
        return "Hello World from Spring Boot";
    }

    //Escribe en la página /goodbye del servidor
    @RequestMapping("/goodbye")
    public String goodbye(){
        return "Goodbye";
    }

}
