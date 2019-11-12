package com.fatec.lab.mineda.repository;

import org.springframework.data.repository.CrudRepository;
import com.fatec.lab.mineda.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);

}
