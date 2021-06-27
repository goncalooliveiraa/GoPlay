package pt.iade.GoPlay.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TipoJogo")

public class TipoJogo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="Nome")
    private String nome;

    public TipoJogo() {}

    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
}
