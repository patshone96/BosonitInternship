package com.example.block7crud.exceptions;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException() {
    }

    public PersonNotFoundException(String message) {
        super(message);
    }
}
