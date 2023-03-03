package com.example.examen_JPA_cascada.LineasFra.infrastructure;

import com.example.examen_JPA_cascada.LineasFra.model.LineasFra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineasFraRepository extends JpaRepository<LineasFra, Integer> {
}
