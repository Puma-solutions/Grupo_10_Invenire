package com.example.Invenire.controllers;

import com.example.Invenire.entities.dtos.UsuarioRegistroDTO;
import com.example.Invenire.services.UsuarioDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {

    private UsuarioDetailsService servicio;

    public InicioController(UsuarioDetailsService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/login")
    public String iniciarSesion(Model model) {
        UsuarioRegistroDTO user = new UsuarioRegistroDTO();
        model.addAttribute("user", user);
        return "views/login";
    }

    @GetMapping("/")
    public String verIndex(Model modelo) {
        return "views/index";
    }

    @GetMapping("/register")
    public String mostrarFormRegistro(Model model){
        UsuarioRegistroDTO user = new UsuarioRegistroDTO();
        model.addAttribute("user", user);
        return "views/registro";
    }

    @PostMapping("/register")
    public String registrarCuentaUsuario(@ModelAttribute("user") UsuarioRegistroDTO usuarioDto, Model model){
        //Falta hacer validaciones de registro. Si ya existe el usuario y campos nulos.
        servicio.registerUser(usuarioDto);
        return "redirect:/register?exito";
    }



}
