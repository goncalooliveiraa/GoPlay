package pt.iade.GoPlay.models.repositories;

import pt.iade.GoPlay.models.Jogo;
import pt.iade.GoPlay.models.views.JogosView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface JogoRepository extends CrudRepository<Jogo, Integer> {
    String QueryFindJogosByDate= "SELECT Jogo_Id as id, Jogo_Data as data, Jogo_Adversario as Adversario, CP_Freguesia as freguesia "+
    "FROM Jogo INNER JOIN CodPostal ON Jogo_Id=CP_Id "+    
    "WHERE timestampdiff(day, Jogo_Data, CURDATE()) < 0 "+
    "AND Jogo_Adversario= '' ";

@Query(value=QueryFindJogosByDate,nativeQuery=true)
Iterable<JogosView> getJogosDisponiveis();
}