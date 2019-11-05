package com.fatec.lab.mineda.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.lab.mineda.view.ViewMesa;
import com.fatec.lab.mineda.view.viewProduto;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({viewProduto.ProdutoGeral.class})
	private Long id;
	@JsonView({viewProduto.ProdutoGeral.class, viewProduto.ProdutoId.class})
	private String nome;
	@JsonView({viewProduto.ProdutoGeral.class})
	private String descricao;
	@JsonView({viewProduto.ProdutoGeral.class})
	private Double preco;
	@JsonView({viewProduto.ProdutoGeral.class, viewProduto.ProdutoTipo.class})
	private String tipo;
	private Date validade;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pedido")
	@JsonView({viewProduto.ProdutoGeral.class, viewProduto.ProdutoPedido.class})
	private Pedido pedido;
	
	//@OneToMany(mappedBy = "bank")
	//private Set<Account> accounts;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = true)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	

}
