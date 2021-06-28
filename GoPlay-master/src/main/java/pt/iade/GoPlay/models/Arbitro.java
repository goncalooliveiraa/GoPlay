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
    @Column (name="Arb_Id")
    private int id;
    @Column (name="Arb_Nome")
    private String nome;
    @Column (name="Arb_TotalJogos")
    private int totalJogos;
    @Column (name="Arb_Pontos")
    private int pontos;

    public Arbitro() {}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getTotalJogos() {
        return totalJogos;
    }

    public int getPontos() {
        return pontos;
    }
}
