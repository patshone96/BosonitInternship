package com.example.examen_JPA_cascada.CabeceraFra.service;

import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import com.example.examen_JPA_cascada.Factura.infrastructure.dto.FacturaOutputDTO;
import com.example.examen_JPA_cascada.LineasFra.infrastructure.dto.LineasFraInputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CabeceraFraService{

    public CabeceraFra addCabecera(CabeceraFra cab);

    public String deleteCabecera(Integer id);

    public List<FacturaOutputDTO> getFacturas();

    public FacturaOutputDTO addLine(LineasFraInputDTO linea, Integer id);

}
