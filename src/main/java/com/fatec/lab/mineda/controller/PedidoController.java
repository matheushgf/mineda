package com.fatec.lab.mineda.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.lab.mineda.entity.Pedido;
import com.fatec.lab.mineda.service.PedidoService;

import javassist.NotFoundException;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<Collection<Pedido>> getAll() {
		return new ResponseEntity<Collection<Pedido>>(pedidoService.getAllPedidos(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/novo-pedido", produces = MediaType.APPLICATION_JSON_VALUE)
	//@JsonView(View.All.class)
	public void savePedido(@RequestBody Pedido pedido) {
		pedidoService.cadastrarPedido(pedido);	
	}
	
	@DeleteMapping(value = "/pedido/{numero}")
	//@JsonView(View.All.class)
	public ResponseEntity<Long>  deletaPedido(@PathVariable Long numPedido) {
		try{
			pedidoService.deletePedido(numPedido);
			return new ResponseEntity<>(numPedido, HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
