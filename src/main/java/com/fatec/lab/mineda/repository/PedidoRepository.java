package com.fatec.lab.mineda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fatec.lab.mineda.entity.Pedido;
import com.fatec.lab.mineda.entity.Produto;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{
	
	Pedido findByNumPedido(final int numPedido);
	
	
	@Query("FROM Pedido p WHERE p.fechado = :status")
	Pedido buscaByStatusFechado (final boolean status);
	
	@Query("FROM Pedido p WHERE p.numPedido = :numPedido")
	List<Produto> getProdutosByPedidoId (final int numPedido);
	
	@Query("FROM Pedido p WHERE p.valor >= :valor and p.fechado = :fechado")
	List<Pedido> getPedidoStatusValor(final float valor, final boolean fechado);
	

}
