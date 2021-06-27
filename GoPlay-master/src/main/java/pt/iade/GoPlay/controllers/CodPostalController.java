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

import pt.iade.GoPlay.models.CodPostal;
import pt.iade.GoPlay.models.exceptions.NotFoundException;
import pt.iade.GoPlay.models.repositories.CodPostalRepository;


@RestController
@RequestMapping(path="/api/codPostal")
public class CodPostalController {
    private Logger logger = LoggerFactory.getLogger(CodPostalController.class);
    @Autowired
    private CodPostalRepository cPRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CodPostal> getCodPostal() {
        logger.info("A enviar todos os codigos postais ");
        return cPRepository.findAll() ;
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public CodPostal getUnit(@PathVariable int id) throws NotFoundException {
        logger.info("A enviar o codigo postal com o id "+id);
        Optional<CodPostal> _codPostal = cPRepository.findById(id);
        if (!_codPostal.isPresent()) throw new NotFoundException(""+id,"CodPostal","id");
        else return _codPostal.get() ;
    }

}