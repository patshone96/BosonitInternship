package com.example.block11uploaddownloadfiles.file.architecture.repository;

import com.example.block11uploaddownloadfiles.file.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Integer> {

    @Query("SELECT f FROM File f WHERE f.fileName = :name")
    Optional<File> getFileByName(String name);






}
