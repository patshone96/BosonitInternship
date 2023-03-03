package com.example.examen_JPA_cascada.Cliente.service;

import com.example.examen_JPA_cascada.Cliente.infrastructure.repository.ClientRepository;
import com.example.examen_JPA_cascada.Cliente.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Cliente addCliente(Cliente c) {
        return clientRepository.save(c);
    }
}
