public package com.tuproyecto.luchalibre.controller; // O el paquete que uses

import com.tuproyecto.luchalibre.entity.Marca;
import com.tuproyecto.luchalibre.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin // Importante para que el Frontend pueda conectarse
@RestController
public class MarcaController {

    @Autowired
    MarcaRepository marcaRepository; // Inyectamos el repositorio que creamos antes

    // Obtener todas las marcas
    @RequestMapping(value = "/marcas", method = RequestMethod.GET)
    public Iterable<Marca> obtenerMarcas(){
        return marcaRepository.findAll();
    }

    // Obtener una marca por ID
    @RequestMapping(value = "/marcas/{id}", method = RequestMethod.GET)
    public Optional<Marca> obtenerMarca(@PathVariable Integer id){
        return marcaRepository.findById(id);
    }

    // Crear una nueva marca
    @RequestMapping(value = "/marcas", method = RequestMethod.POST)
    public void crearMarca(@RequestBody Marca marca){
        marcaRepository.save(marca);
    }

    // Actualizar una marca existente
    @RequestMapping(value = "/marcas/{id}", method = RequestMethod.PUT)
    public void actualizarMarca(@PathVariable Integer id, @RequestBody Marca marca){
        // Aseguramos que el ID del objeto sea el mismo de la URL
        marca.setIdMarca(id);
        marcaRepository.save(marca);
    }

    // Borrar una marca
    @RequestMapping(value = "/marcas/{id}", method = RequestMethod.DELETE)
    public void borrarMarca(@PathVariable Integer id){
        marcaRepository.deleteById(id);
    }
} 
