package com.example.block11uploaddownloadfiles.file.service;

import com.example.block11uploaddownloadfiles.file.architecture.repository.FileRepository;
import com.example.block11uploaddownloadfiles.file.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileRepository fileRepository;

    @Override
    public String addFile(File file) {
        fileRepository.save(file);
        return "Saved successfully";
    }

    @Override
    public File getFile(int idFile) throws FileNotFoundException {

        if(!fileRepository.findById(idFile).isEmpty()){
            return fileRepository.findById(idFile).get();
        }else{
            throw new FileNotFoundException();
        }

    }

    @Override
    public File getFileByName(String name) {
        return null;
    }

    @Override
    public ArrayList<File> getAllFiles() {
        return null;
    }

    @Override
    public void deleteFile(int idFile) {

    }
}
