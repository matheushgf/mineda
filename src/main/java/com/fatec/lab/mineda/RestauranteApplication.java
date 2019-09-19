package com.fatec.lab.mineda;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatec.lab.mineda.service.MesaService;
import com.fatec.lab.mineda.service.ProdutoService;

@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner{
	@Autowired
	private MesaService mesaService;
//	@Autowired
//	private ProdutoService produtoService;
	
	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}
	
	public void setMesaService(MesaService mesaService) {
		this.mesaService = mesaService;
	}
	
//	public void setProdutoService(ProdutoService produtoService) {
//		this.produtoService = produtoService;
//	}
	
	public void run(String... args) throws Exception {
		//mesaService.novaMesa(4);
	}
}
