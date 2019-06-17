package com.johnny.springmultipart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.johnny.springmultipart.service.FileProcessorService;

@RestController
@RequestMapping("/api")
public class UploadController {

	@Autowired
	private FileProcessorService service;

	@PostMapping("/upload")
	public ResponseEntity<String> processUploadedFile(@RequestPart MultipartFile file) {
		if (file == null)
			return ResponseEntity.badRequest().body("No file received!");
		if (service.saveFile(file))
			return ResponseEntity.ok().body("File saved succesfully!");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No file received!");
	}
}
