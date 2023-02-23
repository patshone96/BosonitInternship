package com.example.block11uploaddownloadfiles.file.architecture.controller;

import com.example.block11uploaddownloadfiles.exceptions.ExtensionDoesNotMatch;
import com.example.block11uploaddownloadfiles.exceptions.NameAlreadyUsed;
import com.example.block11uploaddownloadfiles.file.model.File;
import com.example.block11uploaddownloadfiles.file.service.FileServiceImpl;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.boot.ApplicationArguments;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
//@RestController
public class FileController {

    @Autowired
    FileServiceImpl fileService;

    @Autowired
    ApplicationArguments applicationArguments;



    //POST METHOD - this one requires a path variable that specifies the type/ extension of the file. If the provided
    // file does not match the provided extension, an exception is thrown

    @PostMapping("/upload/{type}")
    public String acceptFile(@PathVariable(required = false) String type, @RequestPart MultipartFile upFile) throws ExtensionDoesNotMatch, NameAlreadyUsed, IOException {

        if(type == null){
            throw new IOException("You need to provide an extension on the Path in order to upload files through this endpoint");
        }

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


    //Change the path where the data will be stored
    @GetMapping("/download/id/{id}")
    public String changePath(@PathVariable("id") int fileId) throws IOException {

        //Get all non-optional arguments and set the default path
        List<String> pathArgs = applicationArguments.getNonOptionArgs();
        String pathDownload = "./src/main/downloads/";


      //Check for a parameter on the arguments to change the default path
        if (pathArgs.size() > 0) {
            pathDownload = pathArgs.get(0);
        }

        //We get the file we want to save on another location
        File recoveredFile = fileService.getFile(fileId);

        //We change the recovered file's path
        Path path = Paths.get(pathDownload + recoveredFile.getFileName());

        if (Files.exists(path)) { //If the path already exists, the file will be saved there
            Files.write(path, recoveredFile.getFileData());


        } else {  //In case the path does not exist, it will be created first, and then the file will be saved
            Files.createDirectories(Paths.get(pathDownload));
            Files.write(path, recoveredFile.getFileData());

        }

        return "File has been written successfully on " + pathDownload;
    }



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

    //In case the name of the file alredy exists
    @ExceptionHandler(NameAlreadyUsed.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) //Code of the response
    public String unprocessableEntity(NameAlreadyUsed u){
        return u.getMessage(); //Show the message of the exception
    }

    //In case the provided extension does not match the one from the file we want to upload
    @ExceptionHandler(ExtensionDoesNotMatch.class)
    @ResponseStatus(HttpStatus.CONFLICT) //Code of the response
    public String unmatchedExtension(ExtensionDoesNotMatch u){
        return u.getMessage(); //Show the message of the exception
    }





}
