package com.fatec.lab.atividade02.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;

@Entity
public class Mesa {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private Date hora_aberta;
	
	@Column
	private Date hora_fechada;
	
	@Column
	private int quantidade_lugares;
	
	@Column
	private int quantidade_pessoas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getHora_aberta() {
		return hora_aberta;
	}

	public void setHora_aberta(Date hora_aberta) {
		this.hora_aberta = hora_aberta;
	}

	public Date getHora_fechada() {
		return hora_fechada;
	}

	public void setHora_fechada(Date hora_fechada) {
		this.hora_fechada = hora_fechada;
	}

	public int getQuantidade_pessoas() {
		return quantidade_pessoas;
	}

	public void setQuantidade_pessoas(int quantidade_pessoas) {
		this.quantidade_pessoas = quantidade_pessoas;
	}

	public int getQuantidade_lugares() {
		return quantidade_lugares;
	}

	public void setQuantidade_lugares(int quantidade_lugares) {
		this.quantidade_lugares = quantidade_lugares;
	}
	
	//@ManyToOne	
	//private Pedido pedido;

}
