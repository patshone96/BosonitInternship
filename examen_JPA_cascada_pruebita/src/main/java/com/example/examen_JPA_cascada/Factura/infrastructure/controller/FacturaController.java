package com.example.examen_JPA_cascada.Factura.infrastructure.controller;

import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import com.example.examen_JPA_cascada.CabeceraFra.service.CabeceraFraService;
import com.example.examen_JPA_cascada.Factura.infrastructure.dto.FacturaOutputDTO;
import com.example.examen_JPA_cascada.LineasFra.infrastructure.dto.LineasFraInputDTO;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.InputMismatchException;
import java.util.List;

@RestController
@RequestMapping("factura")
public class FacturaController {

    @Autowired
    CabeceraFraService cabeceraFraService;

    //Show all the Facturas
    @GetMapping
    public ResponseEntity<List<FacturaOutputDTO>> facturas(){
        return new ResponseEntity<>(cabeceraFraService.getFacturas(), HttpStatus.OK);
    }

    //Delete facturas by id
    @DeleteMapping("{idFra}")
    public ResponseEntity<String> deleted(
            @PathVariable Integer idFra
    ){

        return new ResponseEntity<>(cabeceraFraService.deleteCabecera(idFra), HttpStatus.OK);

    }


    //Add lines to a given Facura and returning the result
    @PostMapping("linea/{idFra}")
    public ResponseEntity<FacturaOutputDTO> addLine(
            @PathVariable Integer idFra,
            @RequestBody LineasFraInputDTO linea
    ){
        return new ResponseEntity<>(cabeceraFraService.addLine(linea, idFra), HttpStatus.OK);

    }


    //Handles responses when NoResultException is thrown
    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //Code of the response 404
    public String noResult(NoResultException u){
        return u.getMessage(); //Show the message of the exception
    }

    //Handles responses when there is a Mismatched input
    @ExceptionHandler(InputMismatchException.class)
    @ResponseStatus(HttpStatus.CONFLICT) //Code of the response 404
    public String mismatch(InputMismatchException i){
        return i.getMessage(); //Show the message of the exception
    }








}
