package com.example.examen_JPA_cascada.LineasFra.model;

import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import com.example.examen_JPA_cascada.Cliente.model.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LineasFra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer linFraID;

    @Column(nullable = false)
    private String prodName;

    @Column
    private double quantity;

    @Column
    private double price;

//    @ManyToOne
//    @JoinColumn(name = "fraID")
//    private CabeceraFra cabeceraFra;

}
