package com.example.block7crud.Person.Infrastructure;

public class EmptyFieldsException extends RuntimeException {
    public EmptyFieldsException() {
    }

    public EmptyFieldsException(String message) {
        super(message);
    }
}
