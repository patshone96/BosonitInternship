package com.example.examen_JPA_cascada.Cliente.service;

import com.example.examen_JPA_cascada.Cliente.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {

    public Cliente addCliente(Cliente c);
}
