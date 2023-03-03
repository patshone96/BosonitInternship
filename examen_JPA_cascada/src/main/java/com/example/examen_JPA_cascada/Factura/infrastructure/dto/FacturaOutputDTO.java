package com.example.examen_JPA_cascada.Factura.infrastructure.dto;

import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import com.example.examen_JPA_cascada.Cliente.infrastructure.dto.ClienteOutputDto;
import com.example.examen_JPA_cascada.Cliente.model.Cliente;
import com.example.examen_JPA_cascada.LineasFra.infrastructure.dto.LineasFraOutputDTO;
import com.example.examen_JPA_cascada.LineasFra.model.LineasFra;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class FacturaOutputDTO {

     Integer fraID;
     double importeFra;
     ClienteOutputDto cliente;

     List<LineasFraOutputDTO> lineasFra;

     //List<LineasFra> lineasFra;

    public FacturaOutputDTO(CabeceraFra cf){

        List<LineasFraOutputDTO> lines = new ArrayList<>();
        cf.getLineasFra().stream().forEach(p -> lines.add((new LineasFraOutputDTO(p))));

        this.fraID = cf.getFraID();
        this.importeFra = cf.getImporteFra();
        this.cliente = new ClienteOutputDto(cf.getClient());
        this.lineasFra = lines;
    }




}
