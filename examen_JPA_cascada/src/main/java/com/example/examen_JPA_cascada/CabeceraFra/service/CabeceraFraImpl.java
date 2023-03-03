package com.example.examen_JPA_cascada.CabeceraFra.service;

import com.example.examen_JPA_cascada.CabeceraFra.infrastructure.repository.CabeceraFraRepository;
import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import com.example.examen_JPA_cascada.Factura.infrastructure.dto.FacturaOutputDTO;
import com.example.examen_JPA_cascada.LineasFra.infrastructure.dto.LineasFraInputDTO;
import com.example.examen_JPA_cascada.LineasFra.infrastructure.repository.LineasFraRepository;
import com.example.examen_JPA_cascada.LineasFra.model.LineasFra;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class CabeceraFraImpl implements CabeceraFraService {

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    @Autowired
    LineasFraRepository lineasFraRepository;

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



        return String.format("Factura %d eliminada", id);
    }

    @Override
    public List<FacturaOutputDTO> getFacturas() {

        List<FacturaOutputDTO> facturas = new ArrayList<>();

        cabeceraFraRepository.findAll().stream().forEach(p -> {
            facturas.add(new FacturaOutputDTO(p));
        });

        return facturas;

    }

    @Override
    public FacturaOutputDTO addLine(LineasFraInputDTO linea, Integer id) {

        //The specified id on the path has to match the one provided through the body of the request
        if(id != linea.getIdFra()){
            throw new InputMismatchException("The id provided in the URL and the FraID have to match");
        }

           Optional<CabeceraFra> op = cabeceraFraRepository.findById(linea.getIdFra());

           if (op.isEmpty()){
               throw new NoResultException("Factura not found");
               }

           CabeceraFra cab = op.get();

           LineasFra newLine = new LineasFra();

           newLine.setPrice(linea.getPrice());
           newLine.setQuantity(linea.getQuantity());
           newLine.setProdName(linea.getProdName());

           cab.getLineasFra().add(lineasFraRepository.save(newLine));

           return new FacturaOutputDTO(cabeceraFraRepository.save(cab));






    }
}
