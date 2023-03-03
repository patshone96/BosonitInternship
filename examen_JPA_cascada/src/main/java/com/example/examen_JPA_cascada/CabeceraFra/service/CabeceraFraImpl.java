package com.example.examen_JPA_cascada.CabeceraFra.service;

import com.example.examen_JPA_cascada.CabeceraFra.infrastructure.repository.CabeceraFraRepository;
import com.example.examen_JPA_cascada.CabeceraFra.model.CabeceraFra;
import com.example.examen_JPA_cascada.LineasFra.infrastructure.dto.LineasFraInputDTO;
import com.example.examen_JPA_cascada.LineasFra.infrastructure.repository.LineasFraRepository;
import com.example.examen_JPA_cascada.LineasFra.model.LineasFra;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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



        return "Factura eliminada";
    }

    @Override
    public List<CabeceraFra> getFacturas() {

       return cabeceraFraRepository.findAll();

    }

    @Override
    public CabeceraFra addLine(LineasFraInputDTO linea) {

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

           return cabeceraFraRepository.save(cab);






    }
}
