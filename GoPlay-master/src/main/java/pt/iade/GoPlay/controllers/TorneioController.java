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

import pt.iade.GoPlay.models.Torneio;
import pt.iade.GoPlay.models.exceptions.NotFoundException;
import pt.iade.GoPlay.models.repositories.TorneioRepository;

@RestController
@RequestMapping(path = "/api/torneios")
public class TorneioController {
    private Logger logger = LoggerFactory.getLogger(TorneioController.class);
    @Autowired
    private TorneioRepository torneioRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Torneio> getJogos() {
        logger.info("A enviar todos os torneios");
        return torneioRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Torneio getUnit(@PathVariable int id) throws NotFoundException {
        logger.info("A enviar o torneio com o id " + id);
        Optional<Torneio> _torneio = torneioRepository.findById(id);
        if (!_torneio.isPresent())
            throw new NotFoundException("" + id, "Torneio", "id");
        else
            return _torneio.get();
    }

   /* @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteTorneio(@PathVariable int id) {
        logger.info("A apagar o torneio com o id: " + id);
        torneioRepository.deleteById(id);
        return new Response("A apagar o torneio com o id: "+id, null);
    }*/
}