package com.fatec.lab.mineda.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

class ApiError {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	   private HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   @JsonFormat(shape = JsonFormat.Shape.STRING)
	   private String message;
	   @JsonFormat(shape = JsonFormat.Shape.STRING)
	   private String debugMessage;


	   private ApiError() {
	       timestamp = LocalDateTime.now();
	   }

	   ApiError(HttpStatus status) {
	       this();
	       this.status = status;
	   }
	   
	   ApiError(Throwable ex) {
	       this();
	       this.debugMessage = ex.getLocalizedMessage();	      
	   }

	   ApiError(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	       this.debugMessage = ex.getLocalizedMessage();
	   }
}