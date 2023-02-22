package com.example.block11uploaddownloadfiles.file.service;

import com.example.block11uploaddownloadfiles.exceptions.NameAlreadyUsed;
import com.example.block11uploaddownloadfiles.file.architecture.repository.FileRepository;
import com.example.block11uploaddownloadfiles.file.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;


@Service
public class FileServiceImpl implements FileService {

    //private final ModelMapper modelMapper;

    @Autowired
    FileRepository fileRepository;



    @Override
    public String addFile(File file) throws NameAlreadyUsed, IOException {

        //We store the image on the folder downloads
        byte[] image = file.getFileData();

        if(fileRepository.getFileByName(file.getFileName()).isPresent()) {
            throw new NameAlreadyUsed();
        }
            File f = new File();

                f.setFileData(file.getFileData());
                f.setFileName(file.getFileName());
                f.setCreationDate(new Date());
                f.setType(file.getType());

            fileRepository.save(f);



            String filePath = "./src/main/downloads/";

            // We create an object file (f) which contains the path + the name of the file to store
            java.io.File fil = new java.io.File(filePath, f.getFileName());

            if (fil.exists()) throw new NameAlreadyUsed();


            FileOutputStream fos = new FileOutputStream(fil, false);
            fos.write( file.getFileData() );
            fos.close();

            return "Saved successfully";

    }

    @Override
    public File getFile(int idFile) throws FileNotFoundException {

        if(fileRepository.findById(idFile).isPresent()){
            return fileRepository.findById(idFile).get();
        }else{
            throw new FileNotFoundException();
        }

    }

    @Override
    public File getFileByName(String name) throws FileNotFoundException {

        if(fileRepository.getFileByName(name).isPresent()){
            return fileRepository.getFileByName(name).get();

        }else{
            throw new FileNotFoundException();
        }
    }

    @Override
    public ArrayList<File> getAllFiles() {
        return null;
    }



    @Override
    public void deleteFile(int idFile) {



    }
}
