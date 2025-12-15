public package com.tuproyecto.luchalibre.controller;

import com.tuproyecto.luchalibre.entity.Campeonato;
import com.tuproyecto.luchalibre.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class CampeonatoController {

    @Autowired
    CampeonatoRepository campeonatoRepository;

    // Listar todos los campeonatos
    @RequestMapping(value = "/campeonatos", method = RequestMethod.GET)
    public Iterable<Campeonato> obtenerCampeonatos(){
        return campeonatoRepository.findAll();
    }

    // Buscar uno solo
    @RequestMapping(value = "/campeonatos/{id}", method = RequestMethod.GET)
    public Optional<Campeonato> obtenerCampeonato(@PathVariable Integer id){
        return campeonatoRepository.findById(id);
    }

    // Crear nuevo campeonato
    @RequestMapping(value = "/campeonatos", method = RequestMethod.POST)
    public void crearCampeonato(@RequestBody Campeonato campeonato){
        // El JSON debe traer los IDs de marca y campeonActual
        campeonatoRepository.save(campeonato);
    }

    // Actualizar (Ej. Cambió de dueño el título)
    @RequestMapping(value = "/campeonatos/{id}", method = RequestMethod.PUT)
    public void actualizarCampeonato(@PathVariable Integer id, @RequestBody Campeonato campeonato){
        campeonato.setIdCampeonato(id);
        campeonatoRepository.save(campeonato);
    }

    // Eliminar (Ej. Título desactivado)
    @RequestMapping(value = "/campeonatos/{id}", method = RequestMethod.DELETE)
    public void borrarCampeonato(@PathVariable Integer id){
        campeonatoRepository.deleteById(id);
    }
}