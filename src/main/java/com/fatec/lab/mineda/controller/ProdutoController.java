package com.fatec.lab.mineda.controller;

import com.fatec.lab.mineda.service.ProdutoService;
import com.fatec.lab.mineda.entity.Produto;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/getAll")
	public ResponseEntity<Collection<Produto>> getAll() {
		 return new ResponseEntity<Collection<Produto>>(produtoService.getAllProdutos(), HttpStatus.OK);
	 }
	
}
