package com.fatec.lab.atividade02.service;

import java.util.List;

import com.fatec.lab.atividade02.entity.Mesa;

public interface MesaService {
	public void deleteMesa(Long mesaId);
	public void novaMesa(int quantidade_lugares);
	public List<Mesa> getMesasAbertas();
	public Mesa buscaMesa(int id);
	public void atualizaMesa (int id);
}
