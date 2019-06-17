package com.johnny.springmultipart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileProcessorService {

	private FileOperations file;

	@Autowired
	public FileProcessorService(FileOperations file) {
		this.file = file;
	}

	public boolean saveFile(MultipartFile multiPartFile) {
		if (file.save(multiPartFile))
			return true;
		else
			return false;
	}

}
