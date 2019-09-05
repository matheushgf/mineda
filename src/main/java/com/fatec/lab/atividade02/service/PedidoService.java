package com.fatec.lab.atividade02.service;

import java.util.List;

import com.fatec.lab.atividade02.entity.Mesa;
import com.fatec.lab.atividade02.entity.Pedido;
import com.fatec.lab.atividade02.entity.Produto;

public interface PedidoService {
	public void deletePedido(int id);
	public List<Pedido> getAllPedidos();
	public Pedido buscaPedido(int id);
	public List<Produto> getProdutosPedido(int id);
}
