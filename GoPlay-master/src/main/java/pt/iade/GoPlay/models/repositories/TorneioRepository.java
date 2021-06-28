package pt.iade.GoPlay.models.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.GoPlay.models.Torneio;
import pt.iade.GoPlay.models.views.Inscricao;
import pt.iade.GoPlay.models.views.Torneios;

public interface TorneioRepository extends CrudRepository<Torneio, Integer>{
    String QueryFindTorneioByDate= "SELECT Torn_ID as id, Torn_Data as data, Torn_TipoJogo as tipoJogo, CP_Freguesia as freguesia, Arb_Nome as nome, Torn_Jogadores as numJogadores "+
                "FROM Torneio INNER JOIN CodPostal ON Torn_Id=CP_Id "+
                "INNER JOIN Arbitro ON Torn_Id=Arb_Id "+
                "WHERE timestampdiff(day, Torn_Data, CURDATE()) < 0 "+
                "AND Torn_Jogadores < 30 "+
                "order by Torn_Data asc";



    @Query(value=QueryFindTorneioByDate,nativeQuery=true)
    Iterable<Torneios> getTorneios();

    String inscricoesTorneioQuery = "INSERT INTO Inscricao (Insc_Torneio, Insc_Nome, Insc_Apelido, Insc_Data) VALUES (:Torn_Id, :#{#inscricao.getNome()}, :#{#inscricao.getApelido()}, :#{#inscricao.getData()} )";
    @Modifying
    @Transactional
    @Query(value=inscricoesTorneioQuery, nativeQuery=true)
    int saveTorneioInscricao(@Param("Torn_Id") int Torn_Id, @Param("inscricao") Inscricao inscricao);
} 
    

