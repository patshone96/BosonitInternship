package com.example.block11uploaddownloadfiles.exceptions;

public class NameAlreadyUsed extends Exception{

    public NameAlreadyUsed(){
        super("This name already exists. Change it before storing the file");
    }
}
