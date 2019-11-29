package com.fatec.lab.mineda.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.lab.mineda.entity.Autorizacao;
import com.fatec.lab.mineda.service.AutorizacaoService;


/**
 * @author Emanuel
 *
 */
@RestController
@CrossOrigin
public class AutorizacaoController {
	
	@Autowired
	private AutorizacaoService autorizacaoService;

	public void setAutorizacaoService(AutorizacaoService autorizacaoService) {
		this.autorizacaoService = autorizacaoService;
	}
	
	@RequestMapping(value = "/autorizacao/{nome}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Collection<Autorizacao>> pesquisar(@PathVariable("nome") String nome) {
		return new ResponseEntity<Collection<Autorizacao>>(autorizacaoService.buscar(nome), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/autorizacao/getAll")
	public ResponseEntity<Collection<Autorizacao>> getAll() {
		return new ResponseEntity<Collection<Autorizacao>>(autorizacaoService.todos(), HttpStatus.OK);
	}
	
}
