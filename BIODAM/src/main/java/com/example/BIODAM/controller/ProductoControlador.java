package com.example.BIODAM.controller;

import com.example.BIODAM.model.Producto;
import com.example.BIODAM.services.ProductoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/producto")
    @RequiredArgsConstructor
    public class ProductoControlador {

        private final ProductoServicio productoServicio;

        @GetMapping("/")
        public String list(Model model) {
            model.addAttribute("lista",
                    productoServicio.todosLosProductosConElNombreEnMayusculas());
            return "producto/index";
        }

        @GetMapping("/new")
        public String showFormNewProduct(Model model) {
            model.addAttribute("producto", new Producto());
            return "producto/formulario";
        }

        @PostMapping("/submit")
        public String submitNewProduct(
                @ModelAttribute("producto") Producto producto) {
            productoServicio.save(producto);
            return "redirect:/producto/";
        }


    }
