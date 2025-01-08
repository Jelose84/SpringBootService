package com.pruebas.spring.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.spring.dto.UsuarioDto;
import com.pruebas.spring.dto.UsurioRegistroDto;
import com.pruebas.spring.dto.UsurioUpdateDto;
import com.pruebas.spring.services.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDto> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<UsuarioDto> getUsuarioByNombre(@PathVariable String nombre){
        return usuarioService.getUsuarioByNombre(nombre)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioDto createUsuario(@RequestBody @Valid UsurioRegistroDto usuario){
        return usuarioService.createUsuario(usuario);
    }

    @PutMapping("/{nombre}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable String nombre, @RequestBody @Valid UsurioUpdateDto usuario){
        return usuarioService.updateUsuario(nombre, usuario)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String nombre){
        if(usuarioService.deleteUsuario(nombre)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
