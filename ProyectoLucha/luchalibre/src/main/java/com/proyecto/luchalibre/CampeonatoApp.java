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
public class CampeonatoApp {
    @Autowired
    ICampeonato icampeonato;

    @RequestMapping(value = "/campeonatos", method = RequestMethod.GET)
    public Iterable<Campeonato> getCampeonatos() {
        return icampeonato.findAll();
    }
    @RequestMapping(value = "/campeonato/{id}", method = RequestMethod.GET)
    public Campeonato getCampeonato(@PathVariable Integer id) {
        return icampeonato.findById(id).get();
    }
    @RequestMapping(value = "/campeonato", method = RequestMethod.POST)
    public Campeonato guardarCampeonato(@RequestBody Campeonato campeonato) { 
        return icampeonato.save(campeonato);
    }
    @RequestMapping(value = "/campeonato/{id}", method = RequestMethod.DELETE)
    public void eliminarCampeonato(@PathVariable Integer id) {  
        icampeonato.deleteById(id);
    }
    
}
