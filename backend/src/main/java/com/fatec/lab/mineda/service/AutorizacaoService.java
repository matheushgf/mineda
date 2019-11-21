package com.fatec.lab.mineda.service;

import java.util.List;

import com.fatec.lab.mineda.entity.Autorizacao;

public interface AutorizacaoService {
	
	public Autorizacao salvar(Autorizacao autorizacao);
	
	public void excluir(Long idAutorizacao);
	
	public List<Autorizacao> todos();
	
	public List<Autorizacao> buscar(String nome);
	
	public Autorizacao buscarPorId(Long idAutorizacao);

}
