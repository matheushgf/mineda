package com.fatec.lab.mineda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestErrorException extends RuntimeException{
	public BadRequestErrorException() {
		super("Valores inseridos são incorretos");
	}
}
