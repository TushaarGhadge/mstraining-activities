package com.ibm.mstraining.exception;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)
	{
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CountryCodeNotFoundException.class)
	public final ResponseEntity<Object> handleCountryCodeNotFoundException(Exception ex, WebRequest request)
	{
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors=ex.getBindingResult().getAllErrors().stream().map(e->e.getDefaultMessage()).collect(Collectors.toList());
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), ex.getMessage(), errors.toString());
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	
}
