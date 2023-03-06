package com.example.examen_JPA_cascada.LineasFra.infrastructure.dto;

import com.example.examen_JPA_cascada.LineasFra.model.LineasFra;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class LineasFraOutputDTO {

    String prodName;

    double quantity;

    double price;

    int idFra;

    public LineasFraOutputDTO(LineasFra lineas){
        this.idFra = lineas.getLinFraID();
        this.price = lineas.getPrice();
        this.prodName = lineas.getProdName();
        this.quantity = lineas.getQuantity();

    }

}
