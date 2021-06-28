package pt.iade.GoPlay.models;

import java.util.Date;

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
    @Column(name="Jog_Id")
    private int id;
    @Column (name="Jog_NomeP")
    private String nome;
    @Column (name="Jog_NomeA")
    private String apelido;
    @Column (name="Jog_DataNasc")
    private Date DataNasc;
    @Column (name="Jog_Genero")
    private String genero;
    @Column (name="Jog_Contacto")
    private int contacto;
    @Column (name="Jog_Pontos")
    private int pontos;
    @Column (name="Jog_Username")
    private String username;
    
    public Jogador() {}

    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }

    public String getApelido(){
        return apelido;
    }

    public Date getDataNasc(){
        return DataNasc;
    }

    public String getGenero(){
        return genero;
    }
    public int getContacto(){
        return contacto;
    }

    public int getPontos() {
        return pontos;
    }

    public String getUsername() {
        return username;
    }
}
