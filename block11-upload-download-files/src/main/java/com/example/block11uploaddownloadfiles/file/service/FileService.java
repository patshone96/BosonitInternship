package com.example.block11uploaddownloadfiles.file.service;

import com.example.block11uploaddownloadfiles.file.architecture.repository.FileRepository;
import com.example.block11uploaddownloadfiles.file.model.File;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public interface FileService {

    String addFile(File file);

    File getFile(int idFile) throws FileNotFoundException;

    File getFileByName(String name);

    ArrayList<File> getAllFiles();

    void deleteFile(int idFile);

}
