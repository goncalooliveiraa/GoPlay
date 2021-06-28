package pt.iade.GoPlay.models.views;

import java.sql.Date;

public class Inscricao {
    private int id;
    private String nome;
    private String apelido;
    private Date data;
    
    public Inscricao() {}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public Date getData() {
        return data;
    }


    @Override
    public String toString() {
        return "InscricaoSaveView [Insc_Id=" + id + ", Insc_Nome=" + nome + ", Insc_Apelido=" + apelido + ", Insc_Data="
                + data + "]";
    }

}

    
