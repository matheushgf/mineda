package com.fatec.lab.mineda.controller;

import com.fatec.lab.mineda.service.ProdutoService;
import com.fatec.lab.mineda.view.ViewMesa;
import com.fatec.lab.mineda.view.viewProduto;
import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.lab.mineda.entity.Produto;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/getAll")
	@JsonView({viewProduto.ProdutoGeral.class})
	public ResponseEntity<Collection<Produto>> getAll() {
		 return new ResponseEntity<Collection<Produto>>(produtoService.getAllProdutos(), HttpStatus.OK);
	 }
	
	@PostMapping(value = "/novoProduto", produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView({viewProduto.ProdutoGeral.class})
	public Produto novoProduto(@RequestBody Produto produto, HttpServletResponse response) {
		response.setContentType("application/json");
		produto = produtoService.novoProduto(produto);
		return produto;
	}	
	
	@RequestMapping(value = "/getById/{id}")
	@JsonView({viewProduto.ProdutoGeral.class, viewProduto.ProdutoId.class})
	public ResponseEntity<Produto> getById(@PathVariable("id") int id){
		final Produto produto = produtoService.buscaProduto(Long.valueOf(id));
		
		if(produto != null) {
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		}else {
			return new ResponseEntity<Produto>(produto, HttpStatus.NO_CONTENT);
		}
	}
}
