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
public class MarcaApp {
    @Autowired
    IMarca iMarca;

    @RequestMapping(value = "/marca", method = RequestMethod.GET)
    public Iterable<Marca> getMarca() {
        return iMarca.findAll();
    }
    @RequestMapping(value = "/marca/{id}", method = RequestMethod.GET)
    public Marca getMarca(@PathVariable Integer id) {
        return iMarca.findById(id).get();
    }
    @RequestMapping(value = "/marca", method = RequestMethod.POST)
    public Marca guardarMarca(@RequestBody Marca marca) { 
        return iMarca.save(marca);
    }
    @RequestMapping(value = "/marca/{id}", method = RequestMethod.DELETE)
    public void eliminarMarca(@PathVariable Integer id) {  
        iMarca.deleteById(id);
    }
}
