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

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Fornecedor fornecedor;

    @ManyToOne
    private Pedido pedido;

    public Produto() {
    }

    public Produto(String nome, double preco, Categoria categoria, Fornecedor fornecedor, Pedido pedido) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.pedido = pedido;
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
