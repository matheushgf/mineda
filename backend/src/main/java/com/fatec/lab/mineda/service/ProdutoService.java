package com.fatec.lab.mineda.service;

import java.util.List;

import com.fatec.lab.mineda.entity.Mesa;
import com.fatec.lab.mineda.entity.Pedido;
import com.fatec.lab.mineda.entity.Produto;

public interface ProdutoService {
	public void deleteProduto(Long id);
	public List<Produto> getAllProdutos();
	public Produto buscaProduto(Long id);
	public Produto novoProduto(Produto produto);
}