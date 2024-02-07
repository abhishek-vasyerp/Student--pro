package com.example.crud.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.crud.service.FileServi;
@Service
public class FileServImpl implements FileServi {
	private static final String UPLOAD_DIR = "C:\\Users\\abhishekgalfade\\Downloads\\file";

	@Override
	public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

		try {

			File directory = new File(UPLOAD_DIR);
			if (!directory.exists()) {
				directory.mkdirs();
			}

			String fileName = file.getOriginalFilename();
			Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName);

			Files.write(filePath, file.getBytes(), StandardOpenOption.CREATE);

			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/student/download/")
					.path(fileName).toUriString();

			return ("File uploaded successfully. Download URL: " + fileDownloadUri);
		} catch (IOException ex) {
			return ("Could not upload the file: " + ex.getMessage());
		}

	}

	@Override
	public ResponseEntity<Object> downloadFile(String fileName) {
		ResponseEntity<Object> response = null;
		try {

			Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
			File file = filePath.toFile();

			if (file.exists()) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.setContentDispositionFormData("attachment", fileName);

				response = ResponseEntity.ok().headers(headers).contentLength(file.length())
						.body(new FileSystemResource(file));
			} else {
				response = ResponseEntity.status(404).body("File does'nt exists !!!");
			}
		} catch (Exception ex) {
			response = ResponseEntity.status(500).body("Failed to download the file: " + ex.getMessage());
		}
		return response;
	}

}
