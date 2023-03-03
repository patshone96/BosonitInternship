package com.example.examen_JPA_cascada.CabeceraFra.service;

import com.example.examen_JPA_cascada.CabeceraFra.infrastructure.dto.FacturaOutputDTO;
import com.example.examen_JPA_cascada.CabeceraFra.infrastructure.repository.CabeceraFraRepository;
import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CabeceraFraImpl implements CabeceraFraService {

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    @Override
    public CabeceraFra addCabecera(CabeceraFra cab) {
       return cabeceraFraRepository.save(cab);

    }

    @Override
    public List<CabeceraFra> getFacturas() {

        List<FacturaOutputDTO> facturas = new ArrayList<>();

        ArrayList<CabeceraFra> cb = (ArrayList<CabeceraFra>) cabeceraFraRepository.findAll();

        for (CabeceraFra c: cb) {
            facturas.add(new FacturaOutputDTO(c));

        }

       return cabeceraFraRepository.findAll();


    }
}
