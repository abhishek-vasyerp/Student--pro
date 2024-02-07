package com.example.crud.service.impl;

import com.example.crud.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class UploadServiceImpl implements FileService {


    @Override
    public ResponseEntity<Object> uploadFile(MultipartFile file) throws IOException {

        return null;
    }

    @Override
    public ResponseEntity<Object> downloadFile(String filename) {
        return null;
    }
}
