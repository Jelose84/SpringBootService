package com.pruebas.spring.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class RecetaAlimentoId implements Serializable {
    @ManyToOne
    private Receta receta;

    @ManyToOne
    private Alimento alimento;
}
