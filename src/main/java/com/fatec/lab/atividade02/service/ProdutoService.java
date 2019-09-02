package com.fatec.lab.atividade02.service;

import com.fatec.lab.atividade02.entity.Produto;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.lab.atividade02.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	public ProdutoRepository getProdutoRepository() {
		return produtoRepository;
	}

	public void setProdutoRepository(ProdutoRepository ProdutoRepository) {
		this.produtoRepository = ProdutoRepository;
	}
	
	Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	Produto upadateProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	List<Produto> getAllProdutos() {
		return   (List<Produto>) produtoRepository.findAll();
	}
	   
	public Optional<Produto> getProduto(Long produtoId) {
		return produtoRepository.findById(produtoId);
	}
	
	void deleteProduto(Long produtoId) {
		produtoRepository.deleteById(produtoId);
	}
	
	
}

