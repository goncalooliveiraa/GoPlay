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
    @Column (name="Id")
    private int id;
    @Column (name="NumeroJog")
    private int NumeroJog;
    @Column (name="Data")
    private Date data;

    public Torneio() {}

    public int getId(){
        return id;
    }

    public int getNumeroJog(){
        return NumeroJog;
    }

    public Date getData(){
        return data;
    }
}
