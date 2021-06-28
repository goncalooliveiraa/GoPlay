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

import pt.iade.GoPlay.models.Jogo;
import pt.iade.GoPlay.models.exceptions.NotFoundException;
import pt.iade.GoPlay.models.repositories.JogoRepository;
import pt.iade.GoPlay.models.views.JogosView;


@RestController
@RequestMapping(path="/api/jogos")
public class JogoController {
    private Logger logger = LoggerFactory.getLogger(JogoController.class);
    @Autowired
    private JogoRepository jogoRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Jogo> getJogos() {
        logger.info("A enviar todos os jogos");
        return jogoRepository.findAll();
    }


    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Jogo getUnit(@PathVariable int id) throws NotFoundException {
        logger.info("A enviar jogo com o id "+id);
        Optional<Jogo> _jogo = jogoRepository.findById(id);
        if (!_jogo.isPresent()) throw new NotFoundException(""+id,"Jogo","id");
        else return _jogo.get() ;
    }

    @GetMapping(path = "/lista", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<JogosView> getJogosDisponiveis() {
        logger.info("A enviar a lista de todos os jogos disponiveis ");
        return jogoRepository.getJogosDisponiveis();
    }

    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Jogo saveJogo(@RequestBody Jogo newJogo) {
        logger.info("A guardar jogos com o nome "+newJogo.getId());
        Jogo Jogo = jogoRepository.save(newJogo);
        return Jogo;
    }
}