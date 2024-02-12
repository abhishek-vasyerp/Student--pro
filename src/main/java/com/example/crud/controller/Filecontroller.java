package com.example.crud.controller;


import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.crud.dto.ApiResponse;
import com.example.crud.service.FileServi;

@RestController
@RequestMapping("/files/")
public class Filecontroller {
	@Autowired
	private FileServi fileService;
	
	@PostMapping("/upload")
	public ApiResponse uploadFile(@RequestParam("file")MultipartFile file)throws IOException{
		String response = fileService.uploadFile(file);
		return new ApiResponse(200, "ok", response);
		
	}
	@GetMapping("/download/{filename}")
	 public ResponseEntity<Object> downloadFile(@PathVariable String filename) throws IOException {
//	        Object fileContent = fileService.downloadFile(filename);
	        return fileService.downloadFile(filename);
		
	}
}
//    @PostMapping("append{file1}")
//	public ResponseEntity<Object> appendToFile(@PathVariable String fileName)throws IOException{
//		//ResponseEntity<Object> response = fileService.appendToFile(fileName, Content);
//		return fileService.appendToFile(fileName);
//	}