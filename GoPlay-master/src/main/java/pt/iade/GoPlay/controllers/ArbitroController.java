package pt.iade.GoPlay.controllers;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.GoPlay.models.Arbitro;
import pt.iade.GoPlay.models.exceptions.NotFoundException;
import pt.iade.GoPlay.models.repositories.ArbitroRepository;
import pt.iade.GoPlay.models.views.LeaderboardA;


@RestController
@RequestMapping(path = "/api/arbitros")

public class ArbitroController {
    private Logger logger = LoggerFactory.getLogger(ArbitroController.class);
    @Autowired
    private ArbitroRepository arbitroRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Arbitro> getArbitro(){
        logger.info("A enviar todos os arbitros");
        return arbitroRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Arbitro getUnit(@PathVariable int id) throws NotFoundException {
        logger.info("A enviar o arbitro com o id "+id);
        Optional<Arbitro> _arbitro = arbitroRepository.findById(id);
        if (!_arbitro.isPresent()) throw new NotFoundException(""+id,"Arbitro","id");
        else return _arbitro.get() ;
    }

    @GetMapping(path = "/leaderboardA", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<LeaderboardA> getLeaderboardA() {
        logger.info("A enviar a leaderboard de todos os arbitros ");
        return arbitroRepository.getLeaderboardA();
    }

    @PostMapping(path = "/guardados", produces= MediaType.APPLICATION_JSON_VALUE)
    public Arbitro saveArbitro(@RequestBody Arbitro newArbitro) {
        logger.info("A guardar o arbitro com o nome: "+newArbitro.getNome());
        Arbitro arbitro = arbitroRepository.save(newArbitro);
        return arbitro;
    }
}
