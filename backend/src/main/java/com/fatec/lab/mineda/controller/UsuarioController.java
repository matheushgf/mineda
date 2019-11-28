package com.fatec.lab.mineda.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.lab.mineda.service.UsuarioService;
import com.fatec.lab.mineda.view.ViewSecurity;
import com.fatec.lab.mineda.entity.Usuario;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@RequestMapping(value = "/get/{nome}", method = RequestMethod.GET)
	@JsonView(ViewSecurity.UsuarioCompleto.class)
	public ResponseEntity<Collection<Usuario>> pesquisar(@PathVariable("nome") String nome) {
		return new ResponseEntity<Collection<Usuario>>(usuarioService.buscar(nome), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	@JsonView(ViewSecurity.UsuarioCompleto.class)
	public ResponseEntity<Usuario> get(@RequestParam(value="id", defaultValue="1") Long id) {
		Usuario usuario = usuarioService.buscar(id);
		if(usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@JsonView(ViewSecurity.UsuarioResumoAlternativo.class)
	public ResponseEntity<Collection<Usuario>> getAll() {
		return new ResponseEntity<Collection<Usuario>>(usuarioService.todos(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(ViewSecurity.UsuarioCompleto.class)
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario, UriComponentsBuilder uriComponentsBuilder) {
		usuario = usuarioService.salvar(usuario);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(uriComponentsBuilder.path("/getById?id=" + usuario.getId()).build().toUri());
		return new ResponseEntity<Usuario>(usuario, responseHeaders, HttpStatus.CREATED);
	}
	
}