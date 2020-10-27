package com.example.BIODAM.repos;

import com.example.BIODAM.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

    public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

        Optional<Usuario> findFirstByEmail(String email);

}
