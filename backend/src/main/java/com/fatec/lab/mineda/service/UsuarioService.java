package com.fatec.lab.mineda.service;

import java.util.List;

import com.fatec.lab.mineda.entity.Usuario;

public interface UsuarioService {
	
	public Usuario incluirUsuario(String nome, String senha, String nomeAutorizacao);
	
	public List<Usuario> buscar(String nome);
	
	public Usuario buscar(Long id);
	
	public List<Usuario> todos();
	
	public Usuario salvar(Usuario usuario);

}
