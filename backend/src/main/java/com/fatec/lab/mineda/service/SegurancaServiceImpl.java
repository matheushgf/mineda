package com.fatec.lab.mineda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fatec.lab.mineda.entity.Usuario;
import com.fatec.lab.mineda.repository.UsuarioRepository;

@Service("userDetailsService")
public class SegurancaServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void setUsuarioRepo(UsuarioRepository usuarioRepository) {
	this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Usuario usuario = usuarioRepository.findByUsername(username);
	if(usuario == null) {
	throw new UsernameNotFoundException(username);
	}
	return usuario;
	}


}
