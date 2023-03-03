package com.example.examen_JPA_cascada.CabeceraFra.service;

import com.example.examen_JPA_cascada.CabeceraFra.infrastructure.dto.FacturaOutputDTO;
import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CabeceraFraService{

    public CabeceraFra addCabecera(CabeceraFra cab);

    public List<CabeceraFra> getFacturas();

}
