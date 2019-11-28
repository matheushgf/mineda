package com.fatec.lab.mineda.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.lab.mineda.view.ViewSecurity;

@Entity
public class Anotacao implements Serializable {

	private static final long serialVersionUID = -4175224450033765996L;

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(ViewSecurity.Anotacao.class)
	private Long id;
    
    @Column(length = 100, nullable = false)
    @JsonView(ViewSecurity.Anotacao.class)
    private String assunto;
    
    @Column(name = "ANT_TEXTO", length = 500, nullable = false)
    @JsonView(ViewSecurity.Anotacao.class)
    private String texto;
    
    @Column(name = "ANT_DATA_HORA", nullable = false)
    @JsonView(ViewSecurity.Anotacao.class)
    private Date dataHora;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonView(ViewSecurity.Anotacao.class)
    private Usuario usuario;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}