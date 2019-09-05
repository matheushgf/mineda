package com.fatec.lab.atividade02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void deletePedido(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido buscaPedido(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> getProdutosPedido(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
