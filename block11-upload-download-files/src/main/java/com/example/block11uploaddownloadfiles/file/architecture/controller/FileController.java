package com.example.block11uploaddownloadfiles.file.architecture.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RestController
public class FileController {

    //GET TEST CLASS
    @GetMapping("/hi")
    public String hi(@RequestHeader("name") String name){
        return String.format("hi, %s", name);

    }


}
