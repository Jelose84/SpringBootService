package com.pruebas.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pruebas.spring.dto.UsuarioDto;
import com.pruebas.spring.dto.UsurioRegistroDto;
import com.pruebas.spring.dto.UsurioUpdateDto;

@Service
public class UsuarioService {

    public List<UsuarioDto> getAllUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsuarios'");
    }

    public Optional<UsuarioDto> getUsuarioByNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsuarioByNombre'");
    }

    public UsuarioDto createUsuario(UsurioRegistroDto usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUsuario'");
    }

    public Optional<UsuarioDto> updateUsuario(String nombre, UsurioUpdateDto usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUsuario'");
    }

    public boolean deleteUsuario(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUsuario'");
    }

}
