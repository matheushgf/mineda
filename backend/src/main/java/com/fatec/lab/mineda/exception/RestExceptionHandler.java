package com.fatec.lab.mineda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NotFoundException.class)
	   protected ResponseEntity<Object> handleEntityNotFound(NotFoundException ex) {		
		  ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,ex);	       
		  return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(BadRequestErrorException.class)
	   protected ResponseEntity<Object> handleBadRequestError(BadRequestErrorException ex) {		
		  ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,ex);	       
		  return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	   }
	

}
