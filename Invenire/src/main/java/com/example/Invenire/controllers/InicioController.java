package com.example.Invenire.controllers;

import com.example.Invenire.entities.dtos.UsuarioEditDTO;
import com.example.Invenire.entities.dtos.UsuarioRegistroDTO;
import com.example.Invenire.entities.entities.Pais;
import com.example.Invenire.entities.entities.Usuario;
import com.example.Invenire.services.PaisServiceImpl;
import com.example.Invenire.services.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class InicioController {

    private UsuarioDetailsService servicio;
    @Autowired private PaisServiceImpl paisService;
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

    @GetMapping("/editUser")
    public String mostrarFormEditUser(Model model){
        try{
            Usuario userNativo = servicio.obtenerUsuarioSesion();
            UsuarioEditDTO user = UsuarioEditDTO.builder()
                    .username(userNativo.getUsername())
                    .email(userNativo.getEmail())
                    .celular(userNativo.getCelular())
                    .fechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").format(userNativo.getFechaNacimiento()))
                    .build();
            if(userNativo.getDireccion() != null){
                user.setPais(userNativo.getDireccion().getPais().getNombre());
                user.setCalle(userNativo.getDireccion().getCalle());
                user.setCiudad(userNativo.getDireccion().getCiudad());
                user.setLocalidad(userNativo.getDireccion().getLocalidad());
                user.setCodPostal(userNativo.getDireccion().getCodPostal());
            }
            List<Pais> paises = paisService.findAll();
            model.addAttribute("paises",paises);
            model.addAttribute("user", user);
            return "views/editUser";
        }
        catch(Exception e){
            return "views/index";
        }

    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute("user") UsuarioEditDTO usuarioDto, Model model){
        //REVISA ACA TODOS LOS CAMPOS QUE VIENEN DEL FRONT.
        System.out.printf(usuarioDto.toString());
        return "redirect:/editUser?exito";
    }


    @GetMapping("/ayuda")
    public String mostrarAyuda(Model modelo){
        return "views/help";
    }


}
