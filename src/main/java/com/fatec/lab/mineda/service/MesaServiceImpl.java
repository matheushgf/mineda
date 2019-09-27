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
	
	public void deleteMesa(Long id) {
		this.mesaRepository.deleteById(id);
	}
	
	public Mesa buscaMesa(Long id) {
		Optional<Mesa> mesa = this.mesaRepository.findById(id);
		
		if(mesa.isPresent()) {
			return this.mesaRepository.findById(id).get();
		}else {
			return null;
		}
	}

	public List<Mesa> getMesasAbertas() {
		return this.mesaRepository.findMesa_aberta();
	}
	
	public List<Mesa> getAll() {
		return this.mesaRepository.getAll();
	}

	public void atualizaMesa(Long id) {
		Mesa mesa = this.mesaRepository.findById(id).get();
		this.mesaRepository.save(mesa);
	}
	
	public Mesa fechaMesa(Long id) {
		return this.mesaRepository.fechaMesa(id);
	}

}
