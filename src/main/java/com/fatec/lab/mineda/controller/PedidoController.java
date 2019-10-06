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

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.lab.mineda.entity.Pedido;
import com.fatec.lab.mineda.service.PedidoService;
import com.fatec.lab.mineda.view.ViewPedido;

import javassist.NotFoundException;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/getall")
	@JsonView(ViewPedido.PedidoGeral.class)	
	public ResponseEntity<Collection<Pedido>> getAll() {
		return new ResponseEntity<Collection<Pedido>>(pedidoService.getAllPedidos(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getPedidoById/{numPedido}")
	@JsonView(ViewPedido.PedidoById.class)	
	public ResponseEntity<Pedido> getPedidoById(@PathVariable  Integer numPedido) {
		return new ResponseEntity<Pedido>(pedidoService.buscaPedido(numPedido), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getPedidoByMinValueAndStatus/{valor}/{fechado}")
	@JsonView(ViewPedido.PedidoStatusMInValor.class)	
	public ResponseEntity<Collection<Pedido>>getPedidoStatusMinValor(@PathVariable  Float valor, @PathVariable Boolean fechado) {
		return new ResponseEntity<Collection<Pedido>>(pedidoService.getPedidoStatusMinValor(valor, fechado), HttpStatus.OK);
	}
	
	
	
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public void savePedido(@RequestBody Pedido pedido) throws Exception {
		try
		{
			pedidoService.cadastrarPedido(pedido);
		}
		catch (Exception e)
		{
			throw new Exception("Something went wrong :(");			
		}
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
