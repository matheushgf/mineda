package com.fatec.lab.mineda.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.lab.mineda.entity.Mesa;
import com.fatec.lab.mineda.repository.MesaRepository;

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
	
	public Mesa novaMesa(Mesa mesa) {
		this.mesaRepository.save(mesa);
		return mesa;
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

	@Override
	public List<Mesa> getMesasAbertas() {
		return this.mesaRepository.findMesa_aberta();
	}

	@Override
	public void atualizaMesa(int id) {
		Mesa mesa = this.mesaRepository.findById(id);
		this.mesaRepository.save(mesa);
		
	}

}
