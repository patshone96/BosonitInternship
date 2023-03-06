package com.example.examen_JPA_cascada.LineasFra.service;

import com.example.examen_JPA_cascada.LineasFra.infrastructure.repository.LineasFraRepository;
import com.example.examen_JPA_cascada.LineasFra.model.LineasFra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineasFraServiceImpl implements LineasFraService{

    @Autowired
    LineasFraRepository lineasFraRepository;

    @Override
    public LineasFra addLineas(LineasFra lineas) {
        return lineasFraRepository.save(lineas);
    }
}
