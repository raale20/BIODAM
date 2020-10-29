package com.example.BIODAM.controller;

import com.example.BIODAM.model.Usuario;
import com.example.BIODAM.services.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("lista",
                usuarioServicio.todosLosUsuarios());
        return "usuario/index";
    }

    @GetMapping("/new")
    public String showFormNewUser(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/formulario";
    }

    @PostMapping("/submit")
    public String submitNewUser(
            @ModelAttribute("usuario") Usuario usuario) {
        usuarioServicio.save(usuario);
        return "redirect:/usuario/";
    }

}