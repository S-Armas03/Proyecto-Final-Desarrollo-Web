public package com.tuproyecto.luchalibre.controller;

import com.tuproyecto.luchalibre.entity.Evento;
import com.tuproyecto.luchalibre.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin // Permite que el HTML/JS consuma estos datos
@RestController
public class EventoController {

    @Autowired
    EventoRepository eventoRepository;

    // Obtener todos los eventos
    @RequestMapping(value = "/eventos", method = RequestMethod.GET)
    public Iterable<Evento> obtenerEventos(){
        return eventoRepository.findAll();
    }

    // Obtener un evento específico
    @RequestMapping(value = "/eventos/{id}", method = RequestMethod.GET)
    public Optional<Evento> obtenerEvento(@PathVariable Integer id){
        return eventoRepository.findById(id);
    }

    // Crear evento (Recuerda enviar la fecha como "YYYY-MM-DD")
    @RequestMapping(value = "/eventos", method = RequestMethod.POST)
    public void crearEvento(@RequestBody Evento evento){
        eventoRepository.save(evento);
    }

    // Actualizar evento
    @RequestMapping(value = "/eventos/{id}", method = RequestMethod.PUT)
    public void actualizarEvento(@PathVariable Integer id, @RequestBody Evento evento){
        evento.setIdEvento(id);
        eventoRepository.save(evento);
    }

    // Borrar evento
    @RequestMapping(value = "/eventos/{id}", method = RequestMethod.DELETE)
    public void borrarEvento(@PathVariable Integer id){
        eventoRepository.deleteById(id);
    }
}