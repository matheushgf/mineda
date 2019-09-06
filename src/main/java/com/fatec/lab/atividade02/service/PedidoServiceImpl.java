package com.fatec.lab.atividade02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.lab.atividade02.entity.Mesa;
import com.fatec.lab.atividade02.entity.Pedido;
import com.fatec.lab.atividade02.entity.Produto;
import com.fatec.lab.atividade02.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoRepository pedidoRepository;

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
	public void novoPedido(int quantidade, float valor, boolean fechado, Mesa mesa) {
		Pedido pedido= new Pedido();
		pedido.setQuantidade(quantidade);
		pedido.setValor(valor);
		pedido.setFechado(fechado);
		pedido.setMesa(mesa);
		pedido.reservaMesa();
		this.pedidoRepository.save(pedido);
						
	}

	@Override
	public void fechaPedido(int numPedido) {
		Pedido pedido = this.pedidoRepository.findByNumPedido(numPedido);
		pedido.fechaPedido();
		this.pedidoRepository.save(pedido);
	}
	
}
