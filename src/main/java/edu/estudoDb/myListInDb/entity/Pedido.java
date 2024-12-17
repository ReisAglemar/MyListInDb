package edu.estudoDb.myListInDb.entity;

import edu.estudoDb.myListInDb.patterns.ItoString;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter

public class Pedido implements ItoString {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos = new ArrayList<>();

    public Pedido() {
        this.data = LocalDate.now();
    }

    @Override
    public String toString() {
        String toString = """
                
                Id: %d
                Data do Pedido: %s
                
                """.formatted(this.id, this.data);
        return toString;
    }
}
