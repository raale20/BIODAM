package com.example.BIODAM.services;

import com.example.BIODAM.model.Producto;
import com.example.BIODAM.repos.ProductoRepositorio;
import com.example.BIODAM.services.base.ServicioBaseImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServicio extends
        ServicioBaseImpl<Producto, Long, ProductoRepositorio> {

    public List<Producto> todosLosProductosConElNombreEnMayusculas() {
        return this.findAll().stream()
                .map(p -> {
                    p.setNombre(p.getNombre().toUpperCase());
                    return p;
                }).collect(Collectors.toUnmodifiableList());
    }

}
