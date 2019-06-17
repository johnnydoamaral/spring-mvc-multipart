package com.johnny.springmultipart.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.johnny.springmultipart.FileStoringProperties;
import com.johnny.springmultipart.exception.SaveFileException;
import com.johnny.springmultipart.exception.SaveFileSecurityException;

@Component
public class FileOperationsImpl implements FileOperations {

	private Path rootLocation;

	@Autowired
	public FileOperationsImpl(FileStoringProperties properties) {
		this.rootLocation = Paths.get(properties.getSaveLocation());
	}

	@Override
	public boolean save(MultipartFile file) {
		performEmptyFileCheck(file);
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		performPathSecurityCheck(filename);
		try (InputStream inputStream = file.getInputStream()) {
			Files.copy(inputStream, rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new SaveFileException("Problems while trying to save the file " + filename);
		}
		return true;
	}

	private void performEmptyFileCheck(MultipartFile file) {
		if (file.isEmpty())
			throw new SaveFileException("Empty file.");
	}

	private void performPathSecurityCheck(String filename) {
		if (filename.contains(".."))
			throw new SaveFileSecurityException("Invalid destination path.");
	}

}
