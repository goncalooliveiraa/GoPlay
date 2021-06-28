package pt.iade.GoPlay.models.views;

import java.sql.Date;

public interface Torneios {
    int getId();
    Date getData();
    String getTipoJogo();
    String getFreguesia();
    String getNome();
    int getNumJogadores();
}