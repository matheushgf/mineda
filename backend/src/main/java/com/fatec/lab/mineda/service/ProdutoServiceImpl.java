package com.fatec.lab.mineda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.lab.mineda.entity.Mesa;
import com.fatec.lab.mineda.entity.Pedido;
import com.fatec.lab.mineda.entity.Produto;
import com.fatec.lab.mineda.exception.NotFoundException;
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
	
	public Produto novoProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	Produto updateProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public List<Produto> getAllProdutos() {
		return produtoRepository.getAll();
	}
	   
	public Optional<Produto> getProduto(Long produtoId) {
		return produtoRepository.findById(produtoId);
	}
	

	@Override
	public void deleteProduto(Long id) {
		produtoRepository.deleteById(id);
	}

	@Override
	public Produto buscaProduto(Long id) {
		Optional<Produto> produto = this.produtoRepository.findById(id);
		if(produto.isPresent()) {
			return this.produtoRepository.findById(id).get();
		}else {
			throw new NotFoundException();
		}
	}
}

