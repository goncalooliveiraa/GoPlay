package pt.iade.GoPlay.models.repositories;

import pt.iade.GoPlay.models.Jogo;
//import pt.iade.GoPlay.models.views.JogoFullView;
//import pt.iade.GoPlay.models.views.JogoView;

//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;

public interface JogoRepository extends CrudRepository<Jogo, Integer> {
    /*String jogoQuery = "SELECT  Jogo_Id as id, Jogo_Data as data, Jogo_Adversario as adversario, "+
    "MediaType.Name as mediaType, Genre.Name as genre " +
    "FROM Track, MediaType, Genre "+
    "WHERE Track.GenreId = Genre.GenreId " + 
    "AND Track.MediaTypeId = MediaType.MediaTypeId "+
    "AND Track.AlbumId = :albumId";

    @Query(value=jogoQuery, nativeQuery=true)
    Iterable<JogoView> findJogo(@Param("Jogo_Id") int JogoId);
   
    String saveJogoQuery = "INSERT INTO Track (AlbumId,  Name, MediaTypeId, GenreId, "+
    "Composer, Milliseconds, Bytes, UnitPrice) VALUES (:albumId, :#{#track.getName()}, "+
    ":#{#track.getMediaTypeId()}, :#{#track.getGenreId()}, :#{#track.composer}, "+
    ":#{#track.getMilliseconds()}, :#{#track.getBytes()}, :#{#track.getPrice()} )";
    @Modifying
    @Transactional
    @Query(value=saveJogoQuery, nativeQuery=true)
    int saveJogo(@Param("Jogo_Id") int JogoId, @Param("jogo") JogoFullView jogo);*/
}