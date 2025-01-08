package com.pruebas.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "recetas_alimentos")
@Data
@Builder
public class RecetaAlimento {
    @EmbeddedId
    private RecetaAlimentoId id;

    @Column(nullable = false)
    private String cantidad;

    @Column(nullable = false)
    private Double peso;
}
