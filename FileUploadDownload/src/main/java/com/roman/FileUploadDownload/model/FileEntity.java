package com.roman.FileUploadDownload.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="files")
@Data
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
    private String fileName;

//    @Column(nullable = false)
    private String filePath;
}
