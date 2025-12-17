package com.proyecto.luchalibre;

import jakarta.persistence.*;

@Entity
@Table(name = "Luchador", schema = "freedb_Saludos")
public class Luchador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_luchador")
    private Integer id_luchador;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apodo")
    private String apodo;

    @Column(name = "bando")
    private String bando;

    @Column(name = "id_marca")
    private Integer id_marca;
    
    public Integer getId_luchador() {
        return id_luchador;
    }
    public void setId_luchador(Integer id_luchador) {
        this.id_luchador = id_luchador;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApodo() {
        return apodo;
    }
    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
    public String getBando() {
        return bando;
    }
    public void setBando(String bando) {
        this.bando = bando;
    }
    public Integer getId_marca() {
        return id_marca;
    }
    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }
    
}
