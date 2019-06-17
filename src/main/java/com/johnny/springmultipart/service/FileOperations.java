package com.johnny.springmultipart.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileOperations {

	boolean save(MultipartFile file);

}