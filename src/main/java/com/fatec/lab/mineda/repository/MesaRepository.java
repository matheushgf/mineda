package com.fatec.lab.mineda.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fatec.lab.mineda.entity.Mesa;

public interface MesaRepository extends CrudRepository<Mesa, Long>{
	
	Optional<Mesa> findById(final Long id);

	@Query("FROM Mesa m WHERE m.isOpen = true")
	List<Mesa> findMesa_aberta();
	
	@Query("FROM Mesa m")
	List<Mesa> getAll();
	
	@Query("UPDATE Mesa m SET m.isOpen = false WHERE m.id = :id")
	Mesa fechaMesa(final Long id);
}
