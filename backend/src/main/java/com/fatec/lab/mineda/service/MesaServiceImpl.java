package com.fatec.lab.mineda.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.lab.mineda.entity.Mesa;
import com.fatec.lab.mineda.exception.BadRequestErrorException;
import com.fatec.lab.mineda.exception.NotFoundException;
import com.fatec.lab.mineda.repository.MesaRepository;
import javassist.tools.rmi.ObjectNotFoundException;
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
		//if(mesa.getQuantidade_lugares() <= 0) {
			return this.mesaRepository.save(mesa);
		/*}else {
			throw new BadRequestErrorException();
		}*/
	}
	
	public void deleteMesa(Long id) {
		if(id == null) {
			throw new NotFoundException();
		}else {
			this.mesaRepository.deleteById(id);
		}
	}
	
	public Mesa buscaMesa(Long id) {
		Optional<Mesa> mesa = this.mesaRepository.findById(id);
		if(mesa.isPresent()) {
			return this.mesaRepository.findById(id).get();
		}else {
			throw new NotFoundException();
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
	}
	
	public void fechaMesa(Long id) {
		Mesa idAux = buscaMesa(id);
		if(idAux == null) {
			throw new NotFoundException();
		}else {
			this.mesaRepository.fechaMesa(id);
		}
		
	}

}
