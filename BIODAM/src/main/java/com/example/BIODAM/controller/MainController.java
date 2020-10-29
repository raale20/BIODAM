package com.example.BIODAM.controller;

import com.example.BIODAM.model.Usuario;
import com.example.BIODAM.services.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private UsuarioServicio UsuService;

    @GetMapping({"/index","/"})
    public String index() {
        return "index";
    }

    @GetMapping("/formularioRegistro")//Ancla
    public String formulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formularioRegistro";//Nombre del index
    }

}
