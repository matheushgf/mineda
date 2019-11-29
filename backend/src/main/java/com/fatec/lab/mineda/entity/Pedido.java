package com.fatec.lab.mineda.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.lab.mineda.view.ViewPedido;
import com.fatec.lab.mineda.view.viewProduto;

@Entity
public class Pedido {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({ViewPedido.PedidoGeral.class, ViewPedido.PedidoCadastro.class, ViewPedido.PedidoSemMesa.class, ViewPedido.PedidoStatusMInValor.class})
	private int numPedido;
	
	@JsonView({ViewPedido.PedidoGeral.class, ViewPedido.PedidoCadastro.class, ViewPedido.PedidoSemMesa.class, ViewPedido.PedidoById.class})
	private int quantidade;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="produto_id")
	@JsonView({ViewPedido.PedidoGeral.class, ViewPedido.PedidoCadastro.class, ViewPedido.PedidoById.class})
	private Produto produto;
	
	@JsonView({ViewPedido.PedidoGeral.class, ViewPedido.PedidoCadastro.class, ViewPedido.PedidoSemMesa.class, ViewPedido.PedidoById.class, ViewPedido.PedidoStatusMInValor.class})
	private float valor;

	@JsonView({ViewPedido.PedidoGeral.class, ViewPedido.PedidoCadastro.class,ViewPedido.PedidoCadastro.class, ViewPedido.PedidoSemMesa.class, ViewPedido.PedidoById.class, ViewPedido.PedidoStatusMInValor.class})
	private boolean fechado;
	
	@ManyToOne
	@JsonView({ViewPedido.PedidoGeral.class, ViewPedido.PedidoCadastro.class, ViewPedido.PedidoById.class})
	@JoinColumn(name="mesa_id")
	private Mesa mesa;

	@JsonView({ViewPedido.PedidoGeral.class, ViewPedido.PedidoCadastro.class, ViewPedido.PedidoSemMesa.class,  ViewPedido.PedidoStatusMInValor.class})
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
