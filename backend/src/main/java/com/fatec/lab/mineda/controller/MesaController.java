package com.fatec.lab.mineda.controller;

import com.fatec.lab.mineda.service.MesaService;
import com.fatec.lab.mineda.view.ViewMesa;
import com.fatec.lab.mineda.view.ViewPedido;
import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.lab.mineda.entity.Mesa;
import com.fatec.lab.mineda.entity.Pedido;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mesa")
public class MesaController {
	@Autowired
	private MesaService mesaService;

	@RequestMapping(value = "/getAbertas")
	@JsonView({ ViewMesa.MesaAberta.class })
	@CrossOrigin(origins = "*")
	public ResponseEntity<Collection<Mesa>> getAbertas() {
		return new ResponseEntity<Collection<Mesa>>(mesaService.getMesasAbertas(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAll")
	@JsonView({ ViewMesa.MesaGeral.class })
	@CrossOrigin(origins = "*")
	public ResponseEntity<Collection<Mesa>> getAll() {
		return new ResponseEntity<Collection<Mesa>>(mesaService.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getById/{id}")
	@JsonView({ ViewMesa.MesaGeral.class })
	@CrossOrigin(origins = "*")
	public ResponseEntity<Mesa> getById(@PathVariable("id") int id) {
		final Mesa mesa = mesaService.buscaMesa(Long.valueOf(id));

		if (mesa != null) {
			return new ResponseEntity<Mesa>(mesa, HttpStatus.OK);
		} else {
			return new ResponseEntity<Mesa>(mesa, HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(value = "/novaMesa", produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView({ ViewMesa.MesaGeral.class })
	@CrossOrigin(origins = "*")
	public Mesa novaMesa(@RequestBody Mesa mesa, HttpServletResponse response) {
		response.setContentType("application/json");
		mesa = mesaService.novaMesa(mesa);
		return mesa;
	}

	@GetMapping(value = "/fechaMesa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public void fechaMesa(@PathVariable("id") Long id) {
		mesaService.fechaMesa(id);

	}

	@GetMapping(value = "/getPedidos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView({ ViewPedido.PedidoSemMesa.class })
	@CrossOrigin(origins = "*")
	public List<Pedido> getPedidosMesa(@PathVariable("id") Long id) {
		return this.mesaService.buscaMesa(id).getPedidos();
	}

}
