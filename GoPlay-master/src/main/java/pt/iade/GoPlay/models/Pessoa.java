package pt.iade.GoPlay.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="Pessoa")
public class Pessoa {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="Nome")
    private String nome;
    @Column (name="Apelido")
    private String apelido;
    @Column (name="DataNasc")
    private Date DataNasc;
    @Column (name="Genero")
    private String genero;
    @Column (name="Contacto")
    private int contacto;

    public Pessoa () {}
   

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
    }

    

