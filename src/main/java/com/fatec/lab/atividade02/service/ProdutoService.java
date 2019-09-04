package com.fatec.lab.atividade02.service;

import java.util.List;

import com.fatec.lab.atividade02.entity.Mesa;
import com.fatec.lab.atividade02.entity.Pedido;
import com.fatec.lab.atividade02.entity.Produto;

public interface ProdutoService {
	public void deleteProduto(int id);
	public List<Produto> getAllProdutos();
	public Pedido buscaProduto(int id);
	public Pedido getPedidoProduto(int produto_id);
}
