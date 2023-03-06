package com.example.Block13MongoDB.Person.service;

import com.example.Block13MongoDB.Person.infrastructure.dtos.PersonInputDTO;
import com.example.Block13MongoDB.Person.infrastructure.dtos.PersonOutputDTO;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public interface PersonService {

    public PersonOutputDTO add(PersonInputDTO personInputDTO);

    public PersonOutputDTO get(Long id);

    public List<PersonOutputDTO> getAll();

    public String delete(long id);

    public PersonOutputDTO modify(long id);




}
