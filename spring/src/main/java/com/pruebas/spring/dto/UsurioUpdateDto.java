package com.pruebas.spring.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsurioUpdateDto {

    @NotNull
    private String nombre;

    @NotNull
    private String contrasenaAntigua;

    @NotNull
    private String contrasenaNueva;

}
