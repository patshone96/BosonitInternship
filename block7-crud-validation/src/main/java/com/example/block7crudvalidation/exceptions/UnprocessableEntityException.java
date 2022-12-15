package com.example.block7crudvalidation.exceptions;

public class UnprocessableEntityException extends Exception{

    public UnprocessableEntityException(){
        super("Unprocessable entity. There are empty mandatory fields!");
    }
}
