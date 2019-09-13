package com.fatec.lab.mineda.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fatec.lab.mineda.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{
	
	Pedido findByNumPedido(final int numPedido);
	
	
	@Query("FROM Pedido p WHERE p.fechado = :status")
	Pedido buscaByStatusFechado (final boolean status);
	

}
