package edu.estudoDb.myListInDb.repository;

import edu.estudoDb.myListInDb.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPedido extends JpaRepository<Pedido, Long> {
}
