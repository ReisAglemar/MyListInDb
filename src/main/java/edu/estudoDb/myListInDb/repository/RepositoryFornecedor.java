package edu.estudoDb.myListInDb.repository;

import edu.estudoDb.myListInDb.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryFornecedor extends JpaRepository<Fornecedor, Long> {
}
