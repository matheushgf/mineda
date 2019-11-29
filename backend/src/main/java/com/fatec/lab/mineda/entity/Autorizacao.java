package com.fatec.lab.mineda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.security.core.GrantedAuthority;

import com.fatec.lab.mineda.view.ViewSecurity;

import com.fasterxml.jackson.annotation.JsonView;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "AUT_AUTORIZACAO")
public class Autorizacao implements GrantedAuthority {

	private static final long serialVersionUID = 3078636239920155012L;

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AUT_ID")
	@JsonView({ViewSecurity.UsuarioCompleto.class, ViewSecurity.Autorizacao.class})
	private Long id;
    
    @Column(name = "AUT_NOME", unique=true, length = 20, nullable = false)
    @JsonView({ViewSecurity.UsuarioResumo.class, ViewSecurity.UsuarioResumoAlternativo.class, ViewSecurity.Autorizacao.class})
    private String nome;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String getAuthority() {
		return this.nome;
	}
	
	public void setAuthority(String authority) {
		this.nome = authority;
	}

}
