package edu.estudoDb.myListInDb.repository;

import edu.estudoDb.myListInDb.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduto extends JpaRepository<Produto, Long> {
}
