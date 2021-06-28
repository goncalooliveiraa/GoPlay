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

import pt.iade.GoPlay.models.TipoJogo;
import pt.iade.GoPlay.models.exceptions.NotFoundException;
import pt.iade.GoPlay.models.repositories.TipoJogoRepository;


@RestController
@RequestMapping(path="/api/tipoJogo")
public class TipoJogoController {
    private Logger logger = LoggerFactory.getLogger(TipoJogoController.class);
    @Autowired
    private TipoJogoRepository tipoJogoRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TipoJogo> getJogos() {
        logger.info("A enviar todos os tipos de jogos");
        return tipoJogoRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public TipoJogo getUnit(@PathVariable int id) throws NotFoundException {
        logger.info("A enviar o tipo de jogo com o id "+id);
        Optional<TipoJogo> _tipoJogo = tipoJogoRepository.findById(id);
        if (!_tipoJogo.isPresent()) throw new NotFoundException(""+id,"TipoJogo","id");
        else return _tipoJogo.get() ;
    }


}