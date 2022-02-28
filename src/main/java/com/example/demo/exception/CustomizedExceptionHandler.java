package com.example.demo.exception;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)	
	public  ResponseEntity<String> handleUserNotFound(NoSuchElementException userNotFoundException) {
		return new ResponseEntity<String>("User not found",HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(Exception.class)	
	public  ResponseEntity<String> handleUserNotFound(Exception excetion) {
		return new ResponseEntity<String>("input is empty",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

}
