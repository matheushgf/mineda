package com.fatec.lab.mineda.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fatec.lab.mineda.entity.Mesa;
import com.fatec.lab.mineda.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	Produto findById(final int id);
	
	@Query("FROM Produto p WHERE p.nome = :nome")
	Produto findByNome(final String nome);
	
	@Query("DELETE FROM Produto p WHERE p.id = :id")
	Produto deleteById(final int id);
	
	@Query("FROM Produto p")
	List<Produto> getAll();
}
