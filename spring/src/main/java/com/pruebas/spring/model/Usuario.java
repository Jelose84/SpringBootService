package com.pruebas.spring.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name = "usuarios")
@Data
@Builder
public class Usuario {
    @Id
    private Long id;

    @Column( name = "nombre", nullable = false)
    private String nombre;

    @Column( nullable = false)
    private String contrasena;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Receta> recetas;
}
