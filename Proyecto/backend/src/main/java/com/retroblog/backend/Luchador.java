public package com.tuproyecto.luchalibre.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Luchador")
public class Luchador {

    @Id
    @Column(name = "id_luchador")
    private Integer idLuchador;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apodo")
    private String apodo;

    @Column(name = "bando")
    private String bando;

    // Relación Muchos a Uno: Muchos luchadores pertenecen a Una marca
    @ManyToOne
    @JoinColumn(name = "id_marca") // Este nombre debe coincidir con tu base de datos
    private Marca marca;

    // Constructores, Getters y Setters
    public Luchador() {}

    public Integer getIdLuchador() { return idLuchador; }
    public void setIdLuchador(Integer idLuchador) { this.idLuchador = idLuchador; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApodo() { return apodo; }
    public void setApodo(String apodo) { this.apodo = apodo; }

    public String getBando() { return bando; }
    public void setBando(String bando) { this.bando = bando; }

    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }
}
