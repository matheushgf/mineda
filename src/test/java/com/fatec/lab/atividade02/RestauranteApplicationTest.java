package com.fatec.lab.atividade02;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.lab.atividade02.entity.Mesa;
import com.fatec.lab.atividade02.entity.Pedido;
import com.fatec.lab.atividade02.repository.MesaRepository;
import com.fatec.lab.atividade02.repository.PedidoRepository;
import com.fatec.lab.atividade02.service.MesaService;
import com.fatec.lab.atividade02.service.PedidoServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class RestauranteApplicationTest {
	
	private static final int QUANTIDADE = 1;
	private static final int VALOR = 2;
	private static final boolean FECHADO= true;
	
	@Autowired
	MesaService mesaService;

	@Autowired
	private PedidoRepository pedidoRepo; 
	
	@Autowired
	private PedidoServiceImpl pedidoImpl;
	
	@Autowired
	private MesaRepository mesaRepository;
	
	public void setMesaRepository(MesaRepository mesaRepository) {
		this.mesaRepository = mesaRepository;
	}	
	
	public void setMesaService(MesaService mesaService) {
		this.mesaService = mesaService;
		}
	
	public void setPedidoRepo(PedidoRepository pedidoRepo) {
		this.pedidoRepo = pedidoRepo;
		}
	
	public void setPedidoImpl(PedidoServiceImpl pedidoImpl) {
		this.pedidoImpl = pedidoImpl;
		}
	
	@Before
	public void saveMesa() {
		this.mesaService.novaMesa(4);	
	}
	
	@Test
	public void testeNovoPedidoRepo() {
		Pedido pedido = new Pedido();
		List<Mesa> mesasAsbertas = this.mesaService.getMesasAbertas();
		Mesa mesa = mesasAsbertas.get(0);
		
		pedido.setQuantidade(QUANTIDADE);
		pedido.setValor(VALOR);
		pedido.setFechado(FECHADO);
		pedido.setMesa(mesa);
		pedido.reservaMesa();
		pedidoRepo.save(pedido);
		
		Pedido repo = pedidoRepo.findByNumPedido(pedido.getNumPedido());
		assertNotNull(repo);					
		}
	
	
	@Test
	public void testeNovoPedidoService() {
		Mesa mesa = new Mesa();
		pedidoImpl.novoPedido(QUANTIDADE, VALOR, FECHADO);
		System.out.println("Testeeeeeee  " + this.mesaService.getMesasAbertas().size());
		System.out.println(this.mesaService.getMesasAbertas());
		assertTrue(this.mesaService.getMesasAbertas().size() == 1);
			
	}
	
	
	@Test 
	public void testNovaMesa() {
		
		Mesa mesa = new Mesa();
		mesa.setOpen(true);
		mesa.setQuantidade_lugares(4);
		
		assertTrue((Integer)mesa.getId() != null);
	}
	
	@Test 
	public void testMesaAberta() {
		Mesa mesa = new Mesa();
		mesa.setOpen(true);
		mesa.setQuantidade_lugares(4);
		Mesa mesaRepo = mesaRepository.findMesa_aberta().get(0);
		assertEquals(mesaRepo.getQuantidade_lugares(), mesa.getQuantidade_lugares());
	}
	
}
