package com.fatec.lab.atividade02.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fatec.lab.atividade02.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{
	
	Pedido findByNumPedido(final int numPedido);
	
	
	@Query("FROM Pedido p WHERE p.fechado = :status")
	Pedido buscaByStatusFechado (final boolean status);
	

}
