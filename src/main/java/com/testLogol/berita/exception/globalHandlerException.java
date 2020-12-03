package com.testLogol.berita.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javassist.NotFoundException;

public class globalHandlerException {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(notFoundException ex, WebRequest request){
		errorDetailException ErrorDetailsExc = new errorDetailException(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<>(ErrorDetailsExc, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
		errorDetailException ErroDetailsExc = new errorDetailException(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<>(ErroDetailsExc, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
