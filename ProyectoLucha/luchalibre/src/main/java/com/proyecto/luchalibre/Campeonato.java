package com.proyecto.luchalibre;

import jakarta.persistence.*;

@Entity
@Table(name = "Campeonato", schema = "freedb_Saludos")
public class Campeonato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campeonato")
    private Integer id_campeonato;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "division")
    private String division;

    @Column(name = "id_marca")
    private Integer id_marca;

    @Column(name = "id_campeon_actual")
    private Integer id_campeon_actual;
    
    public Integer getId_campeonato() {
        return id_campeonato;
    }
    public void setId_campeonato(Integer id_campeonato) {
        this.id_campeonato = id_campeonato;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDivision() {
        return division;
    }
    public void setDivision(String division) {
        this.division = division;
    }
    public Integer getId_marca() {
        return id_marca;
    }
    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }
    public Integer getId_campeon_actual() {
        return id_campeon_actual;
    }
    public void setId_campeon_actual(Integer id_campeon_actual) {
        this.id_campeon_actual = id_campeon_actual;
    }
}
