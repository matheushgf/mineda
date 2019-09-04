package com.fatec.lab.atividade02.service;

import java.util.Date;
import java.util.List;

import com.fatec.lab.atividade02.entity.Mesa;

public interface MesaService {
	public void deleteMesa(Long mesaId);
	public void novaMesa(Date hora_aberta, int quantidade_lugares);
	public List<Mesa> getAllMesas();
	public Mesa buscaMesa(int id);
}
