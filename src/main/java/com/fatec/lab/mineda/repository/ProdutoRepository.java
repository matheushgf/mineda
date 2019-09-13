package com.fatec.lab.mineda.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fatec.lab.mineda.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	Produto findById(final int id);
	
	@Query("FROM Produto p WHERE p.nome = :nome")
	Produto findByNome(final String nome);

	
}
