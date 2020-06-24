package com.hunglp.bmo.error_handle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MyResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MyResourceNotFoundException(String message) {
		super(message);
	}
}
