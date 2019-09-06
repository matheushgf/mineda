package com.fatec.lab.atividade02.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numPedido;
	
	private int quantidade;
	
	private float valor;
	
	@Type(type="true_false")
	private boolean fechado;
	
	@ManyToOne
	private Mesa mesa;

	public boolean isFechado() {
		return fechado;
	}

	public void setFechado(boolean fechado) {
		this.fechado = fechado;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	@OneToMany(mappedBy = "pedido")
	private Set<Produto> pipoca;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	} 
	
	public void reservaMesa() {
		this.mesa.setOpen(false);
	}
	
	public void fechaPedido() {
		this.setFechado(true);
		this.mesa.setOpen(true);
				
	}

}
