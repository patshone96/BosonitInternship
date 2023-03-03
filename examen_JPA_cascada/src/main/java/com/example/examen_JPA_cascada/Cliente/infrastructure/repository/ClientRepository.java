package com.example.examen_JPA_cascada.Cliente.infrastructure.repository;

import com.example.examen_JPA_cascada.Cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Integer> {
}
