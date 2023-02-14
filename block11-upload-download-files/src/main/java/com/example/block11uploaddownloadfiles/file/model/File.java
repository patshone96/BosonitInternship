package com.example.block11uploaddownloadfiles.file.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class File {

   public File(MultipartFile file, String name) throws IOException {
      this.fileData = file.getBytes();
      this.fileName = name;
      this.creationDate = new Date();
   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer fileID;

   @Lob
   private byte[] fileData;

   @Column
   private String fileName;

   @Column
   private Date creationDate;

}
