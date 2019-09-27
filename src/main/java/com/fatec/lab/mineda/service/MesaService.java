package com.fatec.lab.mineda.service;

import java.util.List;
import java.util.Optional;

import com.fatec.lab.mineda.entity.Mesa;

public interface MesaService {
	public void deleteMesa(Long id);
	public Mesa novaMesa(Mesa mesa);
	public List<Mesa> getMesasAbertas();
	public List<Mesa> getAll();
	public Mesa buscaMesa(Long id);
	public void atualizaMesa (Long id);
	public Mesa fechaMesa (Long id);
}
