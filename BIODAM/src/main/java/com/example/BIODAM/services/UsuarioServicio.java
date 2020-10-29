package com.example.BIODAM.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.BIODAM.model.Producto;
import com.example.BIODAM.model.Usuario;
import com.example.BIODAM.repos.UsuarioRepositorio;
import com.example.BIODAM.services.base.ServicioBase;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio extends ServicioBase<Usuario, Long, UsuarioRepositorio> {

    public UsuarioServicio(UsuarioRepositorio repo) {
        super(repo);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return repositorio.findFirstByEmail(email);
    }

    public List<Usuario> todosLosUsuarios() {
        return this.findAll().stream()
                .map(p -> {
                    p.getNombre();
                    return p;
                }).collect(Collectors.toUnmodifiableList());
    }

}
