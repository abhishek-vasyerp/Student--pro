package com.example.crud.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    // Method for uploading a file
    String uploadFile(MultipartFile file) throws IOException;

    ResponseEntity<Object> downloadFile(String filename);

}
