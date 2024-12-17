package edu.estudoDb.myListInDb.entity;

import edu.estudoDb.myListInDb.patterns.ItoString;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter


public class Categoria implements ItoString {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String toString = """
                
                Id: %d
                Nome do Categoria: %s
                
                """.formatted(this.id, this.nome);
        return toString;
    }

    public void setProdutos(List<Produto> produtos) {
        produtos.forEach(p-> p.setCategoria(this));
        this.produtos = produtos;
    }
}
