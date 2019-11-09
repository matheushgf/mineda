package com.fatec.lab.mineda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fatec.lab.mineda.entity.Usuario;
import com.fatec.lab.mineda.repository.UsuarioRepository;

public class SegurancaServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepo;
	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
	this.usuarioRepo = usuarioRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Usuario usuario = usuarioRepo.findByNome(username);
	if(usuario == null) {
	throw new UsernameNotFoundException(username);
	}
	return usuario;
	}


}