package edu.estudoDb.myListInDb.entity;

import edu.estudoDb.myListInDb.patterns.ItoString;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter

public class Pedido implements ItoString {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    public Pedido() {
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
