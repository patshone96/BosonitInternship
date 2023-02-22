package com.example.block11uploaddownloadfiles.file.architecture.controller;

import com.example.block11uploaddownloadfiles.exceptions.ExtensionDoesNotMatch;
import com.example.block11uploaddownloadfiles.exceptions.NameAlreadyUsed;
import com.example.block11uploaddownloadfiles.file.model.File;
import com.example.block11uploaddownloadfiles.file.service.FileServiceImpl;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ReactiveTypeDescriptor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLConnection;

@RestController
//@RestController
public class FileController {

    @Autowired
    FileServiceImpl fileService;

    //GET TEST CLASS
    @GetMapping("/hi")
    public String hi(@RequestHeader("name") String name){
        return String.format("hi, %s", name);

    }


    @PostMapping("/upload/{type}")
    public String acceptFile(@PathVariable String type, @RequestPart MultipartFile upFile) throws ExtensionDoesNotMatch, NameAlreadyUsed, IOException {

        //Check if the extensions match
        if(!type.equals(FilenameUtils.getExtension(upFile.getOriginalFilename()))){
            throw new ExtensionDoesNotMatch();
        }

        File newFile = new File();
        newFile.setFileName(upFile.getOriginalFilename());
        newFile.setFileData(upFile.getBytes());
        fileService.addFile(newFile);

        return newFile.getFileName() + " saved succesfully";

    }





//Método para cambiar la dirección donde se guardan los archivos
//    @GetMapping("/download/{fileId}")
//    public String saveOnPath(@PathVariable int fileId, String path) throws FileNotFoundException {
//
//        fileService.getFile(fileId);
//
//
//
//
//
//
//    }


    //Calling this endpoint will show the File not as metadata but as an image, gif, video...
    @GetMapping("/show/{fileId}")
    public ResponseEntity<Object> downloadFileId(@PathVariable("fileId") int fileId) throws FileNotFoundException {
        File file = fileService.getFile(fileId);
        if (file != null) {
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(URLConnection.guessContentTypeFromName(file.getFileName())))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + file.getFileName())
                    .body(new ByteArrayResource(file.getFileData()));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No file was found with id: " + fileId);
        }
    }


    //Upload A FILE
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestPart MultipartFile file) throws Exception {

        File newFile = new File();
        newFile.setFileName(file.getOriginalFilename());
        newFile.setFileData(file.getBytes());
        return fileService.addFile(newFile);

    }

    //GET FILE BY ID
    @GetMapping("{id}")
    public File getFilebyId(@PathVariable int id) throws FileNotFoundException {

        return fileService.getFile(id);
    }


    //GET FILE BY NAME - Also, on the headers we have to specify the variable extension (.jpg, .jifj...)
    @GetMapping("/name/{name}")
    public File getFileByName(@PathVariable String name, @RequestHeader String extension) throws FileNotFoundException {
        return fileService.getFileByName(name+extension);
    }


    //HANDLING CUSTOM EXCEPTIONS
    @ExceptionHandler(NameAlreadyUsed.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) //Code of the response
    public String unprocessableEntity(NameAlreadyUsed u){
        return u.getMessage(); //Show the message of the exception
    }

    @ExceptionHandler(ExtensionDoesNotMatch.class)
    @ResponseStatus(HttpStatus.CONFLICT) //Code of the response
    public String unmatchedExtension(ExtensionDoesNotMatch u){
        return u.getMessage(); //Show the message of the exception
    }





}
