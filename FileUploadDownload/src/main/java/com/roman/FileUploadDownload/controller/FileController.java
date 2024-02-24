package com.roman.FileUploadDownload.controller;


import com.roman.FileUploadDownload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file){
       return fileService.saveFile(file);
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> handleFIleDownload(@PathVariable Long fileId) {
        return fileService.getFileById(fileId);
    }
}
