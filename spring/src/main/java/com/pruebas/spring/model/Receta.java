package com.pruebas.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "recetas")
@Data
@Builder
public class Receta {
    @Id
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String dificultad;

    private Double calorias;

    @Column(nullable = false)
    private String instrucciones;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
