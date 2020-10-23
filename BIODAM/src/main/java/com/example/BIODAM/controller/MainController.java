package com.example.BIODAM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/formulario")//Ancla
    public String formulario() {
        return "formulario";//NOmbre del index
    }

}
