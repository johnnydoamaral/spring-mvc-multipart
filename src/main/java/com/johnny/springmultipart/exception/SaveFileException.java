package com.johnny.springmultipart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class SaveFileException extends RuntimeException {

	private static final long serialVersionUID = -6417230780430480208L;

	public SaveFileException(String message) {
		super(message);
	}

}
