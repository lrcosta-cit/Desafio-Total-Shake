package br.com.desafio.totalshake.repository;

import br.com.desafio.totalshake.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
