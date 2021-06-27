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
    @Column(name="Id")
    private int id;
    @Column(name="Data")
    private Date data;
    @Column(name="Local")
    private String local;

    public Jogo() {}

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }
}
