package pt.iade.GoPlay.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Jogo")

public class Jogo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="Jogo_Id")
    private int id;
    @Column(name="Jogo_Data")
    private Date data;
    @Column(name="Jogo_Adversario")
    private String adversario;

    public Jogo() {}

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getAdversario() {
        return adversario;
    }
}
