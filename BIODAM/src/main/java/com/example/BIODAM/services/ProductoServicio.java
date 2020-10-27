package com.example.BIODAM.services;

import com.example.BIODAM.model.Producto;
import com.example.BIODAM.repos.ProductoRepositorio;
import com.example.BIODAM.services.base.IServicioBase;
import com.example.BIODAM.services.base.ServicioBase;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServicio extends ServicioBase<Producto, Long, ProductoRepositorio> {

    public ProductoServicio(ProductoRepositorio repo) {
        super(repo);
    }

    //Tengo que pillar el método de poner todo en mayúsculas y quitarle eso para que muestre todo los productos
    //Por eso el error en ProductoControlador
}
