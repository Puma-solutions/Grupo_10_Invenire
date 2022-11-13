package com.example.Invenire.controllers;

import com.example.Invenire.entities.dtos.CursoCardDTO;
import com.example.Invenire.entities.dtos.VistoDTO;
import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.services.CursoService;
import com.example.Invenire.services.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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


    @GetMapping("/{id}")
    public String mostrarDetalleCurso(@PathVariable Long id, Model modelo){
        Curso curso = servicio.buscarCursoPorIdYUsuario(id,userService.obtenerUsuarioSesion());
        VistoDTO visto = new VistoDTO();
        modelo.addAttribute("visto",visto);
        modelo.addAttribute("curso",curso);
        return "views/cursos/cursoDetalle";
    }

    @GetMapping("/misCursos/{pageNo}")
    public String misCursosPaged(@PathVariable (value = "pageNo") int pageNo,
                                 @RequestParam("sortField") String sortField,
                                 @RequestParam("sortDir") String sortDir,
                                 Model model) {
        int pageSize = 6;
        Page<Curso> page = servicio.buscarCursoPorUsuarioPaginado(pageNo, pageSize, sortField, sortDir);
        List<Curso> listaCursos = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listCursos", listaCursos);
        return "views/cursos/mis_cursos";
    }

/*    @PostMapping("/visto/{idCurso}/{idDetalle}")
    public String test(@ModelAttribute("visto") VistoDTO visto, Model modelo,@PathVariable Long idCurso,@PathVariable Long idDetalle){
        System.out.println(visto);
        return "redirect:";
    }*/

}
