package com.fatec.lab.mineda.service;

import java.util.List;

import com.fatec.lab.mineda.entity.Anotacao;

public interface AnotacaoService {

	public Anotacao salvar(Anotacao autorizacao);
	
	public void excluir(Long idAnotacao);
	
	public List<Anotacao> todos();
	
	public List<Anotacao> buscarPorUsuario(String nome);
	
	public Anotacao buscarPorId(Long idAnotacao);

}
