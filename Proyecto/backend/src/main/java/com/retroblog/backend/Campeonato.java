public package com.tuproyecto.luchalibre.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Campeonato")
public class Campeonato {

    @Id
    @Column(name = "id_campeonato")
    private Integer idCampeonato;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "division")
    private String division;

    // Relación con la Marca dueña del título
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    // Relación con el Luchador que tiene el título
    @ManyToOne
    @JoinColumn(name = "id_campeon_actual") // Nombre de la columna en tu BD
    private Luchador campeonActual;

    // Constructores, Getters y Setters
    public Campeonato() {}

    public Integer getIdCampeonato() { return idCampeonato; }
    public void setIdCampeonato(Integer idCampeonato) { this.idCampeonato = idCampeonato; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDivision() { return division; }
    public void setDivision(String division) { this.division = division; }

    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }

    public Luchador getCampeonActual() { return campeonActual; }
    public void setCampeonActual(Luchador campeonActual) { this.campeonActual = campeonActual; }
}