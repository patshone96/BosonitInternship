package com.example.examen_JPA_cascada.CabeceraFra.service;

import com.example.examen_JPA_cascada.CabeceraFra.infrastructure.dto.FacturaOutputDTO;
import com.example.examen_JPA_cascada.CabeceraFra.infrastructure.repository.CabeceraFraRepository;
import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CabeceraFraImpl implements CabeceraFraService {

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    @Override
    public CabeceraFra addCabecera(CabeceraFra cab) {
       return cabeceraFraRepository.save(cab);

    }

    @Override
    public String deleteCabecera(Integer id) {

        Optional<CabeceraFra> op = cabeceraFraRepository.findById(id);

        if (op.isEmpty()){
            throw new NoResultException("Factura not found");
        }else{
            cabeceraFraRepository.deleteById(id);
        }



        return "Factura eliminada";
    }

    @Override
    public List<CabeceraFra> getFacturas() {

       return cabeceraFraRepository.findAll();

    }
}
