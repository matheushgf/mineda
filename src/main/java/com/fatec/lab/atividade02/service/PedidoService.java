package com.fatec.lab.atividade02.service;

import java.util.List;

import com.fatec.lab.atividade02.entity.Mesa;
import com.fatec.lab.atividade02.entity.Pedido;
import com.fatec.lab.atividade02.entity.Produto;

public interface PedidoService {
	public void deletePedido(Long numPedido);
	public void novoPedido(int quantidade, float valor, boolean fechado, Mesa mesa);
	public void fechaPedido(int numPedido);
	public List<Pedido> getAllPedidos();
	public Pedido buscaPedido(int numPedido);
	public List<Produto> getProdutosPedido(int numPedido);
}
