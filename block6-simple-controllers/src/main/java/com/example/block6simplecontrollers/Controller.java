package com.example.block6simplecontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("hola")
    public String getParam1(@PathVariable String arg1){
        return String.format("arg1, %s", arg1);
    }

    @GetMapping("{arg2}")
    public String getParam2(@PathVariable String arg2){
        return String.format("arg2, %s", arg2);
    }
}
