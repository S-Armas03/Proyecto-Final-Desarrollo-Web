package com.proyecto.luchalibre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@RestController
public class EventosApp {
    @Autowired
    IEventos iEventos;

    @RequestMapping(value = {"/evento", "/eventos"}, method = RequestMethod.GET)
    public Iterable<Eventos> getEventos() {
        return iEventos.findAll();
    }
    @RequestMapping(value = "/evento/{id}", method = RequestMethod.GET)
    public Eventos getEvento(@PathVariable Integer id) {
        return iEventos.findById(id).orElse(null);
    }
    @RequestMapping(value = "/evento", method = RequestMethod.POST)
    public Eventos guardarEvento(@RequestBody Eventos evento) { 
        return iEventos.save(evento);
    }
    @RequestMapping(value = "/evento/{id}", method = RequestMethod.DELETE)
    public void eliminarEvento(@PathVariable Integer id) {  
        iEventos.deleteById(id);
    }
    @RequestMapping(value = "/eventos/count", method = RequestMethod.GET)
    public long contarEventos() {
        return iEventos.count();
    }
}
