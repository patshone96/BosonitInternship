package com.example.block11uploaddownloadfiles.exceptions;

import lombok.experimental.SuperBuilder;

public class ExtensionDoesNotMatch extends Exception{

    public ExtensionDoesNotMatch(){
        super("The extension provided and the file extension do not coincide. Please, specify a correct extension");
    }
}
