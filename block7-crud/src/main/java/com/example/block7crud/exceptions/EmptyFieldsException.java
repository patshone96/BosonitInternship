package com.example.block7crud.exceptions;

public class EmptyFieldsException extends RuntimeException {
    public EmptyFieldsException() {
    }

    public EmptyFieldsException(String message) {
        super(message);
    }
}
