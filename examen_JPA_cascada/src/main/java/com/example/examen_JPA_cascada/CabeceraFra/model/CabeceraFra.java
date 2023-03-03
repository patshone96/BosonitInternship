package com.example.examen_JPA_cascada.CabeceraFra.model;

import com.example.examen_JPA_cascada.Cliente.model.Cliente;
import com.example.examen_JPA_cascada.LineasFra.model.LineasFra;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.sound.sampled.Line;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CabeceraFra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fraID;

    @Column
    private double importeFra = 0;

    @ManyToOne()
    @JoinColumn(name = "clientID")
    private Cliente client;


    @OneToMany(fetch=FetchType.LAZY,
            cascade = CascadeType.DETACH)
    @JoinColumn(name="Lines")
    private List<LineasFra> lineasFra;

//    @OneToMany(mappedBy="linFraID")
//    private List<LineasFra> lineasFra;
}
