package com.roman.FileUploadDownload.service;

import com.roman.FileUploadDownload.model.FileEntity;
import com.roman.FileUploadDownload.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public FileEntity saveFile(FileEntity file){
        return fileRepository.save(file);
    }

    public Optional<FileEntity> getFileById(Long fileId){
        return fileRepository.findById(fileId);
    }
}
