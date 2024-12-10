package edu.estudoDb.myListInDb.entity;

import edu.estudoDb.myListInDb.patterns.ItoString;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter


public class Categoria implements ItoString {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Categoria() {
    }

    public Categoria(long id, String nome) {
        this.id = id;
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
}