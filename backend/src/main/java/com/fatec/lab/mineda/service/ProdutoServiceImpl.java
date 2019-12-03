package com.fatec.lab.mineda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional
	public Produto novoProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
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

