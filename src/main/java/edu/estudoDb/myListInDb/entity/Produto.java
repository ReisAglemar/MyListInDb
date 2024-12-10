package edu.estudoDb.myListInDb.entity;

import edu.estudoDb.myListInDb.patterns.ItoString;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class Produto implements ItoString {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, name = "valor")
    private double preco;

    public Produto() {
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        String toString = """
                
                Id: %d
                Nome do Produto: %s
                Valor do Produto: R$ %.2f
                
                """.formatted(this.id, this.nome, this.preco);
        return toString;
    }
}
