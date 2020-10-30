package com.example.BIODAM.repos;

import com.example.BIODAM.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

    Optional<Producto> findFirstByName(String nombre);
}
