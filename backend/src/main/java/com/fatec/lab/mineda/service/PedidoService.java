package com.fatec.lab.mineda.service;

import java.util.List;

import com.fatec.lab.mineda.entity.Mesa;
import com.fatec.lab.mineda.entity.Pedido;
import com.fatec.lab.mineda.entity.Produto;

public interface PedidoService {
	public void deletePedido(Long numPedido);
	public void novoPedido(int quantidade, float valor, boolean fechado);
	public void fechaPedido(int numPedido);
	public List<Pedido> getAllPedidos();
	public Pedido buscaPedido(int numPedido);
	public List<Produto> getProdutosPedido(int numPedido);
	public void cadastrarPedido(Pedido pedido);
	public List<Pedido> getPedidoStatusMinValor(float valor, boolean fechado);
}
