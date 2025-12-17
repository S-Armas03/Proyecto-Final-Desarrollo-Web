package com.proyecto.luchalibre;

import jakarta.persistence.*;

@Entity
@Table(name = "Marca", schema = "freedb_Saludos")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Integer id_marca;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "pais")
    private String pais;
    
    public Integer getId_marca() {
        return id_marca;
    }
    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
}
