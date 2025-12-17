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
public class LuchadorApp {
    @Autowired
    ILuchador iLuchador;

    @RequestMapping(value = "/luchador", method = RequestMethod.GET)
    public Iterable<Luchador> getLuchador() {
        return iLuchador.findAll();
    }
    @RequestMapping(value = "/luchador/{id}", method = RequestMethod.GET)
    public Luchador getLuchador(@PathVariable Integer id) {
        return iLuchador.findById(id).get();
    }
    @RequestMapping(value = "/luchador", method = RequestMethod.POST)
    public Luchador guardarLuchador(@RequestBody Luchador luchador) { 
        return iLuchador.save(luchador);
    }
    @RequestMapping(value = "/luchador/{id}", method = RequestMethod.DELETE)
    public void eliminarLuchador(@PathVariable Integer id) {  
        iLuchador.deleteById(id);
    }
    
}
