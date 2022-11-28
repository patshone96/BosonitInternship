package com.example.block7crud.Person.Infrastructure;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException() {
    }

    public PersonNotFoundException(String message) {
        super(message);
    }
}
