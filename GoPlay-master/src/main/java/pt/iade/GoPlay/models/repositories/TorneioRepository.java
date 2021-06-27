package pt.iade.GoPlay.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.GoPlay.models.CodPostal;
import pt.iade.GoPlay.models.Torneio;

public interface TorneioRepository extends CrudRepository<Torneio, Integer>{

    Iterable<Torneio> findById(String text);
    String QueryFindTorneioByLocation= 
                "SELECT  FROM colaborador WHERE colaborador.username=:colab_username and colaborador.password=:colab_password";
    @Query(value=QueryFindTorneioByLocation,nativeQuery=true)
    Iterable<CodPostal> FindColabByUsernameAndPassword(@Param ("colab_username") String username, @Param ("colab_password") String password);
    Iterable<CodPostal> findByEmpresaId(Integer empresaId);
}
    

