package com.pruebas.spring.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsurioRegistroDto {

    @NotNull
    private String nombre;

    @NotNull(message = "La contraseña no puede estar vacia")
    private String contrasena;
}
