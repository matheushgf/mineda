package com.fatec.lab.mineda.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.lab.mineda.view.ViewPedido;
import com.fatec.lab.mineda.view.ViewMesa;
import javax.persistence.OneToMany;

@Entity
public class Mesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({ViewMesa.MesaGeral.class, ViewMesa.MesaId.class, ViewPedido.PedidoGeral.class, ViewPedido.PedidoCadastro.class, ViewPedido.PedidoById.class})
	private Long id;
	
	@JsonView({ViewMesa.MesaGeral.class, ViewMesa.MesaAberta.class, ViewPedido.PedidoGeral.class, ViewPedido.PedidoCadastro.class, ViewPedido.PedidoById.class})
	private boolean isOpen;
	
	@JsonView({ViewMesa.MesaGeral.class, ViewPedido.PedidoGeral.class, ViewPedido.PedidoCadastro.class, ViewPedido.PedidoById.class})
	private int quantidade_lugares;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade_lugares() {
		return quantidade_lugares;
	}

	public void setQuantidade_lugares(int quantidade_lugares) {
		this.quantidade_lugares = quantidade_lugares;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	@OneToMany(mappedBy = "mesa")
	private List<Pedido> pedidos;
	
	public List<Pedido> getPedidos(){
		return this.pedidos;
	}
}
