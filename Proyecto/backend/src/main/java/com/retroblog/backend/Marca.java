package com.tuproyecto.luchalibre.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Marca")
public class Marca {

    @Id
    @Column(name = "id_marca")
    private Integer idMarca;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "pais")
    private String pais;

    // Constructores, Getters y Setters
    public Marca() {}

    public Marca(Integer idMarca, String nombre, String pais) {
        this.idMarca = idMarca;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Integer getIdMarca() { return idMarca; }
    public void setIdMarca(Integer idMarca) { this.idMarca = idMarca; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
}
