package edu.estudoDb.myListInDb.repository;

import edu.estudoDb.myListInDb.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCategoria extends JpaRepository<Categoria, Long> {
}
