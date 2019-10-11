package com.fatec.lab.mineda.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
	public NotFoundException() {
		super("Item não encontrado");
	}
}