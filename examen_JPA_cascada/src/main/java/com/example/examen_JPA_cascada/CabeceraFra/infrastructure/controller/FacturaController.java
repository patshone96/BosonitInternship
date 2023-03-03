package com.example.examen_JPA_cascada.CabeceraFra.infrastructure.controller;

import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import com.example.examen_JPA_cascada.CabeceraFra.service.CabeceraFraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("factura")
public class FacturaController {

    @Autowired
    CabeceraFraService cabeceraFraService;

    @GetMapping
    public ResponseEntity<List<CabeceraFra>> response(
    ){
        return new ResponseEntity<>(cabeceraFraService.getFacturas(), HttpStatus.OK);

    }





}
