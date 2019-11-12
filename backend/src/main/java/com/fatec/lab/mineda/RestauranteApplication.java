package com.fatec.lab.mineda;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.fatec.lab.mineda.entity.Mesa;
import com.fatec.lab.mineda.entity.Pedido;
import com.fatec.lab.mineda.service.MesaService;
import com.fatec.lab.mineda.service.PedidoService;
import com.fatec.lab.mineda.service.ProdutoService;
import com.fatec.lab.mineda.service.SegurancaServiceImpl;

@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner{
	@Autowired
	private MesaService mesaService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private UserDetailsService userDetailsService;
	
	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}
	
	public void setMesaService(MesaService mesaService) {
		this.mesaService = mesaService;
	}
	
	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	public void run(String... args) throws Exception {
		Mesa m = new Mesa();
		m.setOpen(true);
		m.setQuantidade_lugares(5);
		mesaService.novaMesa(m);
		
		Pedido p = new Pedido();
		p.setMesa(m);
		p.setFechado(false);
		p.setQuantidade(6);
		p.setValor((float) 67.8);
		p.reservaMesa();
		pedidoService.cadastrarPedido(p);
		
		System.out.println("Olá");
		System.out.println(mesaService.buscaMesa(m.getId()).getQuantidade_lugares());
	}
}
