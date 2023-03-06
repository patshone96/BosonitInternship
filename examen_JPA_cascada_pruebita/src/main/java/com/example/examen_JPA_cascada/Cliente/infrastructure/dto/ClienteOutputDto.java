package com.example.examen_JPA_cascada.Cliente.infrastructure.dto;

import com.example.examen_JPA_cascada.Cliente.model.Cliente;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ClienteOutputDto {

    Integer clientID;

    String name;

    public ClienteOutputDto(Cliente cliente){
        this.clientID = cliente.getClientID();
        this.name = cliente.getName();
    }


}
