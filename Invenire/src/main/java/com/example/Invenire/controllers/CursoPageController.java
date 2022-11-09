package com.example.Invenire.controllers;

import com.example.Invenire.entities.dtos.CursoCardDTO;
import com.example.Invenire.entities.dtos.VistoDTO;
import com.example.Invenire.entities.entities.Curso;
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

    @GetMapping("/search")
    public String searchCursos(@RequestParam("search") String search, Model modelo){
        List<CursoCardDTO> cursos = servicio.buscarCursosPorNombreYPorUsuario(search,userService.obtenerUsuarioSesion());
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
        VistoDTO visto = new VistoDTO();
        modelo.addAttribute("visto",visto);
        modelo.addAttribute("curso",curso);
        return "views/cursos/cursoDetalle";
    }

/*    @PostMapping("/visto/{idCurso}/{idDetalle}")
    public String test(@ModelAttribute("visto") VistoDTO visto, Model modelo,@PathVariable Long idCurso,@PathVariable Long idDetalle){
        System.out.println(visto);
        return "redirect:";
    }*/

}
