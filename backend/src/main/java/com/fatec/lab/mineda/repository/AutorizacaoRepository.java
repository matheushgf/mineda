package com.fatec.lab.mineda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fatec.lab.mineda.entity.Autorizacao;

public interface AutorizacaoRepository extends CrudRepository<Autorizacao, Long> {

	public List<Autorizacao> findByNomeContainsIgnoreCase(String nome);
	
}
