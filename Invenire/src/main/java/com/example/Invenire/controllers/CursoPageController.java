package com.example.Invenire.controllers;

import com.example.Invenire.entities.dtos.CursoCardDTO;
import com.example.Invenire.entities.dtos.SearchDTO;
import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.entities.entities.Usuario;
import com.example.Invenire.services.CursoService;
import com.example.Invenire.services.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("cursos")
public class CursoPageController {
    private CursoService servicio;
    @Autowired private UsuarioDetailsService userService;
    public CursoPageController(CursoService servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/search")
    public String searchCursos(@ModelAttribute("searchDTO") SearchDTO searchDTO, Model modelo){
        List<CursoCardDTO> cursos = servicio.buscarCursosPorNombreYPorUsuario(searchDTO.getFiltro(),userService.obtenerUsuarioSesion());
        modelo.addAttribute("cursos",cursos);
        return "views/cursos/search";
    }

    @GetMapping("/")
    public String mostrarCursos(Model modelo){

        return "views/cursos/cursos";
    }

    @GetMapping("/{id}")
    public String mostrarDetalleCurso(@PathVariable Long id, Model modelo){
        Curso curso = servicio.buscarCursoPorIdYUsuario(id,userService.obtenerUsuarioSesion());
        modelo.addAttribute("curso",curso);
        return "views/cursos/cursoDetalle";
    }

}
