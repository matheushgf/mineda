package com.fatec.lab.mineda.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fatec.lab.mineda.entity.Mesa;

public interface MesaRepository extends CrudRepository<Mesa, Long>{
	
	Mesa findById(final int id);

	@Query("FROM Mesa m WHERE m.isOpen = true")
	List<Mesa> findMesa_aberta();
	
}
