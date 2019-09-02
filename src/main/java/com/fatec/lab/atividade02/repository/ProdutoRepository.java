package com.fatec.lab.atividade02.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fatec.lab.atividade02.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	Produto findById(final int id);
	
	@Query("FROM Produto p WHERE p.nome = :nome")
	Produto findByNome(final String nome);

	
}
