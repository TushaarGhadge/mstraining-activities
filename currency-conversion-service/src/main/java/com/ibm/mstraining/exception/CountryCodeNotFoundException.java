package com.ibm.mstraining.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class CountryCodeNotFoundException extends RuntimeException {
	public CountryCodeNotFoundException(String message)
	{
		super(message);
	}
}
