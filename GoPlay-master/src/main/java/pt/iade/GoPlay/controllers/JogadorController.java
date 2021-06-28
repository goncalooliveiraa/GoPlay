package pt.iade.GoPlay.controllers;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.GoPlay.models.Jogador;
import pt.iade.GoPlay.models.exceptions.NotFoundException;
import pt.iade.GoPlay.models.repositories.JogadorRepository;
import pt.iade.GoPlay.models.views.LeaderboardJ;
import pt.iade.GoPlay.models.views.ListaJogadores;



@RestController
@RequestMapping(path="/api/jogadores")
public class JogadorController {
    private Logger logger = LoggerFactory.getLogger(JogadorController.class);
    @Autowired
    private JogadorRepository jogadorRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Jogador> getJogador() {
        logger.info("A enviar todos os jogadores");
        return jogadorRepository.findAll() ;
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Jogador getUnit(@PathVariable int id) throws NotFoundException {
        logger.info("A enviar o jogador com o id "+id);
        Optional<Jogador> _jogador = jogadorRepository.findById(id);
        if (!_jogador.isPresent()) throw new NotFoundException(""+id,"Jogador","id");
        else return _jogador.get() ;
    }

    @GetMapping(path = "/leaderboardJ", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<LeaderboardJ> getLeaderboardJ() {
        logger.info("A enviar a leaderboard de todos jogadores ");
        return jogadorRepository.getLeaderboardJ();
    }

    @GetMapping(path = "/lista", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ListaJogadores> getListaJogadores() {
        logger.info("A enviar a lista de todos os jogadores na sua zona: ");
        return jogadorRepository.getListaJogadores();
    }

}