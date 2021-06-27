package pt.iade.GoPlay.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Jogador")

public class Jogador {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column (name="Pontos")
    private int pontos;
    @Column (name="Username")
    private String username;
    
    public Jogador() {}

    public int getId(){
        return id;
    }

    public int getPontos() {
        return pontos;
    }

    public String getUsername() {
        return username;
    }
}
