package com.example.examen_JPA_cascada.Factura.infrastructure.controller;

import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import com.example.examen_JPA_cascada.CabeceraFra.service.CabeceraFraService;
import com.example.examen_JPA_cascada.LineasFra.infrastructure.dto.LineasFraInputDTO;
import jakarta.persistence.NoResultException;
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
    public ResponseEntity<List<CabeceraFra>> facturas(){
        return new ResponseEntity<>(cabeceraFraService.getFacturas(), HttpStatus.OK);

    }

    @DeleteMapping("{idFra}")
    public ResponseEntity<String> deleted(
            @PathVariable Integer idFra
    ){

        return new ResponseEntity<>(cabeceraFraService.deleteCabecera(idFra), HttpStatus.OK);


    }

    @PostMapping("linea/{idFra}")
    public ResponseEntity<CabeceraFra> addLine(
            @PathVariable Integer idFra,
            @RequestBody LineasFraInputDTO linea
    ){

        return new ResponseEntity<>(cabeceraFraService.addLine(linea), HttpStatus.OK);


    }


    //Handles responses when UnprocessableEntityException is thrown
    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //Code of the response
    public String unprocessableEntity(NoResultException u){
        return u.getMessage(); //Show the message of the exception
    }






}
