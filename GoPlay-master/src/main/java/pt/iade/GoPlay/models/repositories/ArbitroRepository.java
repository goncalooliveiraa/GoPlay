package pt.iade.GoPlay.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.GoPlay.models.Arbitro;
import pt.iade.GoPlay.models.views.LeaderboardA;


public interface ArbitroRepository extends CrudRepository<Arbitro, Integer> {
        String arbitroQuery = "select Arb_Id  AS id, Arb_Nome as Nome, Arb_Pontos as Pontos "+
        "FROM Arbitro " + 
        "order by Arb_Pontos desc";
    
        @Query(value=arbitroQuery, nativeQuery=true)
        Iterable<LeaderboardA> getLeaderboardA();
}
    

