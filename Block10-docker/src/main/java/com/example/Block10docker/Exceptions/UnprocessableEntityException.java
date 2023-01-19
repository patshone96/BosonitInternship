package com.example.Block10docker.Exceptions;

public class UnprocessableEntityException extends Exception{

    public UnprocessableEntityException(){
        super("Unprocessable entity. There are empty mandatory fields!");
    }
}
