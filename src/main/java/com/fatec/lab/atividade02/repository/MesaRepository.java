package com.fatec.lab.atividade02.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fatec.lab.atividade02.entity.Mesa;

public interface MesaRepository extends CrudRepository<Mesa, Long>{
	
	Mesa findById(final int id);
	
	@Query("FROM Mesa m WHERE m.hora_aberta = :hora_aberta")
	Mesa findByHora_aberta(final Date hora_aberta);
	

}
