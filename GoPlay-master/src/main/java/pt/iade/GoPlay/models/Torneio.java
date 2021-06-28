package pt.iade.GoPlay.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Torneio")

public class Torneio {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="Torn_Id")
    private int id;
    @Column (name="Torn_Jogadores")
    private int numJogadores;
    @Column (name="Torn_Data")
    private Date data;
    @Column (name="Torn_TipoJogo")
    private String tipoJogo;

    public Torneio() {}

    public int getId(){
        return id;
    }

    public int getNumJogadores(){
        return numJogadores;
    }

    public Date getData(){
        return data;
    }
    public String getTipoJogo(){
        return tipoJogo;
    }
}

