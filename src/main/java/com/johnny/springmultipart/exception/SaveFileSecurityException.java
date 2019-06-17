package com.johnny.springmultipart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SaveFileSecurityException extends RuntimeException {

	private static final long serialVersionUID = -2915134091166240062L;

	public SaveFileSecurityException(String message) {
		super(message);
	}

}
