package edu.estudoDb.myListInDb.entity;

import edu.estudoDb.myListInDb.patterns.ItoString;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class Fornecedor implements ItoString {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Fornecedor() {
    }

    public Fornecedor(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String toString = """
                
                Id: %d
                Nome do Produto: %s
                Valor do Produto: R$ %.2f
                
                """.formatted(this.id, this.nome);
        return toString;
    }
}
