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

/*
        String candidaturaQuery = "SELECT  Arb_Id as id, Arb_Nome as nome, Arb_DataNasc as DataNascimento "+
    "FROM Arbitro ";

    @Query(value=candidaturaQuery, nativeQuery=true)
    Iterable<ArbitroView> findArbitroNome(@Param("id") int id);
   
    String guardarCandidaturaQuery = "INSERT INTO Arbitro (Id, Nome, dataNasc, "+
    "VALUES (:Id, :#{#arbitro.getNome()}, "+
    ":#{#arbitro.getDataNasc()} )";

    @Modifying
    @Transactional
    @Query(value=guardarCandidaturaQuery, nativeQuery=true)
    int saveArbitroNome(@Param("id") int id, @Param("nome") ArbitroFullView nome);*/
    }
    

