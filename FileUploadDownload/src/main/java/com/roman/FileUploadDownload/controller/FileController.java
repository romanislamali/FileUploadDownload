package com.roman.FileUploadDownload.controller;


import com.roman.FileUploadDownload.model.FileEntity;
import com.roman.FileUploadDownload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file){

        String uploadDirectory = "src/main/resources/uploads/";
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Path uploadPath = Paths.get(uploadDirectory);

        try{
            Files.copy(file.getInputStream(), uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            FileEntity fileEntity = new FileEntity();
                fileEntity.setFileName(fileName);
                fileEntity.setFilePath(uploadPath.resolve(fileName).toString());
                fileService.saveFile(fileEntity);
                return ResponseEntity.ok("File Uploaded Successful!!");
        }catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Upload file!!");
        }
    }


}
