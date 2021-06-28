package pt.iade.GoPlay.models.views;

import java.sql.Date;

public class ArbitroFullView {
    private int id;
    private String nome;
    private Date dataNasc;

    
    public ArbitroFullView() {}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    @Override
    public String toString() {
        return "ArbitroSaveView [dataNasc=" + dataNasc + ", id ="+ id+", name="+ nome + "]";
    }

    

}