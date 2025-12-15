public package com.tuproyecto.luchalibre.controller;

import com.tuproyecto.luchalibre.entity.Luchador;
import com.tuproyecto.luchalibre.repository.LuchadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@CrossOrigin
@RestController
public class LuchadorController {

    @Autowired
    LuchadorRepository luchadorRepository;

    @RequestMapping(value = "/luchadores", method = RequestMethod.GET)
    public Iterable<Luchador> obtenerLuchadores(){
        return luchadorRepository.findAll();
    }

    @RequestMapping(value = "/luchadores/{id}", method = RequestMethod.GET)
    public Optional<Luchador> obtenerLuchador(@PathVariable Integer id){
        return luchadorRepository.findById(id);
    }

    @RequestMapping(value = "/luchadores", method = RequestMethod.POST)
    public void crearLuchador(@RequestBody Luchador luchador){
        // Spring Boot es inteligente: Si el JSON trae {"marca": {"idMarca": 1}},
        // él sabrá asignar la relación automáticamente.
        luchadorRepository.save(luchador);
    }

    @RequestMapping(value = "/luchadores/{id}", method = RequestMethod.PUT)
    public void actualizarLuchador(@PathVariable Integer id, @RequestBody Luchador luchador){
        luchador.setIdLuchador(id);
        luchadorRepository.save(luchador);
    }

    @RequestMapping(value = "/luchadores/{id}", method = RequestMethod.DELETE)
    public void borrarLuchador(@PathVariable Integer id){
        luchadorRepository.deleteById(id);
    }

    // EXTRA: Endpoint personalizado usando el repositorio que creamos
    // URL ejemplo: .../luchadores/bando/Rudo
    @RequestMapping(value = "/luchadores/bando/{bando}", method = RequestMethod.GET)
    public List<Luchador> buscarPorBando(@PathVariable String bando){
        return luchadorRepository.findByBando(bando);
    }
} 