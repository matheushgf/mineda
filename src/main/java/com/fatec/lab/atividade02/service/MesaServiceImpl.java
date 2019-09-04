package com.fatec.lab.atividade02.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.lab.atividade02.entity.Mesa;
import com.fatec.lab.atividade02.repository.MesaRepository;

@Service
public class MesaServiceImpl implements MesaService {
	@Autowired
	private MesaRepository mesaRepository;

	public MesaRepository getmesaRepository() {
		return mesaRepository;
	}

	public void setmesaRepository(MesaRepository mesaRepository) {
		this.mesaRepository = mesaRepository;
	}
	
	public void novaMesa(Date hora_aberta, int quantidade_lugares) {
		Mesa mesa = new Mesa();
		mesa.setHora_aberta(hora_aberta);
		mesa.setQuantidade_lugares(quantidade_lugares);
		this.mesaRepository.save(mesa);
	}
	
	public List<Mesa> getAllMesas() {
		return   (List<Mesa>) mesaRepository.findAll();
	}
	
	public Optional<Mesa> getProduto(Long mesaId) {
		return mesaRepository.findById(mesaId);
	}
	
	public void deleteMesa(Long mesaId) {
		this.mesaRepository.deleteById(mesaId);
	}
	public Mesa buscaMesa(int id) {
		return this.mesaRepository.findById(id);
	}
	
}
