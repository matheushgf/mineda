package com.fatec.lab.mineda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.lab.mineda.entity.Pedido;
import com.fatec.lab.mineda.entity.Produto;
import com.fatec.lab.mineda.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	public ProdutoRepository getProdutoRepository() {
		return produtoRepository;
	}

	public void setProdutoRepository(ProdutoRepository ProdutoRepository) {
		this.produtoRepository = ProdutoRepository;
	}
	
	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	Produto updateProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public List<Produto> getAllProdutos() {
		return   (List<Produto>) produtoRepository.findAll();
	}
	   
	public Optional<Produto> getProduto(Long produtoId) {
		return produtoRepository.findById(produtoId);
	}
	

	@Override
	public void deleteProduto(int id) {
		produtoRepository.deleteById(id);
	}

	@Override
	public Produto buscaProduto(int id) {
		return produtoRepository.findById(id);
	}
}

