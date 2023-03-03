package com.example.examen_JPA_cascada.CabeceraFra.service;

import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import com.example.examen_JPA_cascada.LineasFra.infrastructure.dto.LineasFraInputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CabeceraFraService{

    public CabeceraFra addCabecera(CabeceraFra cab);

    public String deleteCabecera(Integer id);

    public List<CabeceraFra> getFacturas();

    public CabeceraFra addLine(LineasFraInputDTO linea);

}
