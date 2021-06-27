package pt.iade.GoPlay.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.GoPlay.models.Jogador;
import pt.iade.GoPlay.models.views.LeaderboardJ;

public interface JogadorRepository extends CrudRepository<Jogador, Integer>{
    String jogadoresQuery = "select Jog_Id  AS id, Jog_NomeP as Nome, Jog_NomeA as Apelido, Jog_Pontos as pontos "+
    "FROM Jogador " + 
    "order by Jog_Pontos desc";

    @Query(value=jogadoresQuery, nativeQuery=true)
    Iterable<LeaderboardJ> getLeaderboardJ();

}


/*
public interface JogadorRepository extends CrudRepository<Jogador, Integer>{
    Iterable<Jogador> findByNameContaining(String text);

    @Query (value="SELECT Jog_Id as id," +
            "Jog_NomeP as nome, "+
            "Jog_NomeA as apelido, "+
            "Jog_Pontos as pontos"
            ,nativeQuery=true)
            Jogador FindJogadorId( int id);
}*/