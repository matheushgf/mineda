package com.fatec.lab.mineda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.lab.mineda.entity.Mesa;
import com.fatec.lab.mineda.entity.Pedido;
import com.fatec.lab.mineda.entity.Produto;
import com.fatec.lab.mineda.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private MesaService mesaService;

	public PedidoRepository getPedidoRepository() {
		return pedidoRepository;
	}

	public void setPedidoRepository(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	
	public void cadastrarPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public Optional<Pedido> getPedido(Long pedidoId) {
		return pedidoRepository.findById(pedidoId);
	}
	
	public List<Pedido> getAllPedidos() {
		return   (List<Pedido>) pedidoRepository.findAll();
	}

	@Override
	public void deletePedido(Long numPedido) {
		this.pedidoRepository.deleteById(numPedido);	
	}

	@Override
	public Pedido buscaPedido(int numPedido) {
		return this.pedidoRepository.findByNumPedido(numPedido);		
	}

	@Override
	public List<Produto> getProdutosPedido(int numPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void novoPedido(int quantidade, float valor, boolean fechado) {
		
		Pedido pedido= new Pedido();		
		Mesa mesa = this.mesaService.getMesasAbertas().get(0);
			
		pedido.setQuantidade(quantidade);
		pedido.setValor(valor);
		pedido.setFechado(fechado);
		pedido.setMesa(mesa);
		pedido.reservaMesa();
		this.mesaService.atualizaMesa(mesa.getId());		
		this.pedidoRepository.save(pedido);
						
	}

	@Override
	public void fechaPedido(int numPedido) {
		Pedido pedido = this.pedidoRepository.findByNumPedido(numPedido);
		pedido.fechaPedido();
		this.pedidoRepository.save(pedido);
	}
	
}
