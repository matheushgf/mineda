package com.fatec.lab.mineda.service;

import java.util.List;

import com.fatec.lab.mineda.entity.Mesa;

public interface MesaService {
	public void deleteMesa(Long mesaId);
	public Mesa novaMesa(Mesa mesa);
	public List<Mesa> getMesasAbertas();
	public Mesa buscaMesa(int id);
	public void atualizaMesa (int id);
}
