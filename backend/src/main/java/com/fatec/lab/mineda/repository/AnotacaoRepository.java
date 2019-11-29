package com.fatec.lab.mineda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatec.lab.mineda.entity.Anotacao;

public interface AnotacaoRepository extends CrudRepository<Anotacao, Long> {
	
	public List<Anotacao> findByUsuarioNome(String nome);

}
