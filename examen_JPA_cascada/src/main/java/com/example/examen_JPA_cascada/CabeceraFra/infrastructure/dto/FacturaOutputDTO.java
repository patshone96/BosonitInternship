package com.example.examen_JPA_cascada.CabeceraFra.infrastructure.dto;

import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import com.example.examen_JPA_cascada.Cliente.model.Cliente;
import com.example.examen_JPA_cascada.LineasFra.model.LineasFra;
import lombok.ToString;


import java.util.List;

@ToString
public class FacturaOutputDTO {


    private Integer fraID;


    private double importeFra;


    private Cliente client;


    private List<LineasFra> lineasFra;

    public FacturaOutputDTO(CabeceraFra cf){

        this.fraID = cf.getFraID();
        this.importeFra = cf.getImporteFra();
        this.client = cf.getClient();
        this.lineasFra = cf.getLineasFra();

    }




}
