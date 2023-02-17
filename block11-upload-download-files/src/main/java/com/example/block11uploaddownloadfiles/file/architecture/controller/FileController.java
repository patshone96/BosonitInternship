package com.example.block11uploaddownloadfiles.file.architecture.controller;

import com.example.block11uploaddownloadfiles.file.model.File;
import com.example.block11uploaddownloadfiles.file.service.FileService;
import com.example.block11uploaddownloadfiles.file.service.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestPart MultipartFile file) throws IOException {
        File newFile = new File();

        newFile.setFileName(file.getOriginalFilename());
        newFile.setFileData(file.getBytes());

        return fileService.addFile(newFile);


    }

    @GetMapping("{id}")
    public File getFilebyId(@PathVariable int id) throws FileNotFoundException {

        return fileService.getFile(id);
    }


}
