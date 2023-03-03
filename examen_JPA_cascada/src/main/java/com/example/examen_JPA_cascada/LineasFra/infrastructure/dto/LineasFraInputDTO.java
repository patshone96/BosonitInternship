package com.example.examen_JPA_cascada.LineasFra.infrastructure.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LineasFraInputDTO {


     String prodName;

     double quantity;

     double price;

     int idFra;





}
