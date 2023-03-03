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

    //Saves a CabeceraFra to the Repository
    @Override
    public CabeceraFra addCabecera(CabeceraFra cab) {
       return cabeceraFraRepository.save(cab);

    }

    //Delete a cabecera by id. It also deletes all data associated to them
    @Override
    public String deleteCabecera(Integer id) {

        //We check for the CabeceraFra on the repository
        Optional<CabeceraFra> op = cabeceraFraRepository.findById(id);

        if (op.isEmpty()){ //If there isn't any CabeceraFra with the provided ID, an exception is thrown
            throw new NoResultException("Factura not found");
        }else{

            //Recover the CabeceraFra object from the optional
            CabeceraFra cab = op.get();

            //Recover the CabeceraFra Lineas
            List<LineasFra> lineasCab = cab.getLineasFra();

            //Delete the lines one by one using the deleteById using the ID getter
            lineasCab.stream().forEach(p -> lineasFraRepository.deleteById(p.getLinFraID()));

            //Finally, we delete the CabeceraFra
            cabeceraFraRepository.deleteById(id);
        }

        return String.format("Factura %d eliminada", id);
    }

    //Shows all the Facturas stored
    @Override
    public List<FacturaOutputDTO> getFacturas() {


        List<FacturaOutputDTO> facturas = new ArrayList<>();

        //We recover the data from the cabeceraFra repo and cast every object to FacturaOutputDTO
        //These are stored in the list facturas
        cabeceraFraRepository.findAll().stream().forEach(p -> {
            facturas.add(new FacturaOutputDTO(p));
        });

        //Return the list
        return facturas;

    }

    //Adds a line to a given Factura
    @Override
    public FacturaOutputDTO addLine(LineasFraInputDTO linea, Integer id) {

        //The specified id on the path has to match the one provided through the body of the request
        if(id != linea.getIdFra()){
            throw new InputMismatchException("The id provided in the URL and the FraID have to match");
        }

            //Check if there is a Cabecera with the provided ID
           Optional<CabeceraFra> op = cabeceraFraRepository.findById(linea.getIdFra());

           if (op.isEmpty()){ //If there isn't a cabecera, we throw an exception
               throw new NoResultException("Factura not found");
               }

           //If there is a Cabecera, we retrieve it from the Optional.
           CabeceraFra cab = op.get();

           //Declare a line object
           LineasFra newLine = new LineasFra();


           // Set the attributes of the new line
           newLine.setPrice(linea.getPrice());
           newLine.setQuantity(linea.getQuantity());
           newLine.setProdName(linea.getProdName());


           // Save the line created with the .save method from the lineas repo
          //And as this method returns an instance of the Lineas object
          //We add the instance to the lineasFra of cabecera
           cab.getLineasFra().add(lineasFraRepository.save(newLine));

           //Finally, return a FacturaDTO
           return new FacturaOutputDTO(cabeceraFraRepository.save(cab));

    }
}
