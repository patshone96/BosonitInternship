package com.example.block11uploaddownloadfiles.file.service;

import com.example.block11uploaddownloadfiles.exceptions.NameAlreadyUsed;
import com.example.block11uploaddownloadfiles.file.model.File;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@Service
public interface FileService {

    String addFile(File file) throws NameAlreadyUsed, IOException;

    File getFile(int idFile) throws FileNotFoundException;

    File getFileByName(String name) throws FileNotFoundException;


}
