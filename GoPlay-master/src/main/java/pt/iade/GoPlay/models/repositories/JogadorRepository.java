package pt.iade.GoPlay.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.GoPlay.models.Jogador;
import pt.iade.GoPlay.models.views.LeaderboardJ;
import pt.iade.GoPlay.models.views.ListaJogadores;

public interface JogadorRepository extends CrudRepository<Jogador, Integer>{
    String jogadoresQuery = "select Jog_Id  AS id, Jog_NomeP as Nome, Jog_NomeA as Apelido, Jog_Pontos as pontos "+
    "FROM Jogador " + 
    "order by Jog_Pontos desc";

    @Query(value=jogadoresQuery, nativeQuery=true)
    Iterable<LeaderboardJ> getLeaderboardJ();


    String listaJogadoresQuery = "select Jog_Id  AS id, Jog_NomeP as Nome, Jog_NomeA as Apelido, Jog_Genero as genero, Jog_Contacto as contacto, CP_Freguesia as freguesia "+
    "FROM Jogador INNER JOIN CodPostal ON Jog_Id=CP_Id "+
    "WHERE CP_Freguesia = 'Faro'";

    @Query(value=listaJogadoresQuery, nativeQuery=true)
    Iterable<ListaJogadores> getListaJogadores();
}