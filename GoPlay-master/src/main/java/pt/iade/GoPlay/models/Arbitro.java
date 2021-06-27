package pt.iade.GoPlay.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Arbitro")

public class Arbitro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="Id")
    private int id;
    @Column (name="TotalJogos")
    private int totalJogos;
    @Column (name="Pontos")
    private int pontos;

    public Arbitro() {}

    public int getId() {
        return id;
    }

    public int getTotalJogos() {
        return totalJogos;
    }

    public int getPontos() {
        return pontos;
    }
}
