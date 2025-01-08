package com.pruebas.spring.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class RecetaAlimentoId implements Serializable {
    @Column
    private Long idReceta;

    @Column
    private Long idAlimento;
}
