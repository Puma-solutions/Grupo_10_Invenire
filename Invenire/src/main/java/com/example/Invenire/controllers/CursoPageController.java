package com.example.Invenire.controllers;

import com.example.Invenire.entities.dtos.CursoCardDTO;
import com.example.Invenire.entities.dtos.SearchDTO;
import com.example.Invenire.entities.dtos.UsuarioEditDTO;
import com.example.Invenire.entities.dtos.VistoDTO;
import com.example.Invenire.entities.entities.Categoria;
import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.entities.entities.CursoUsuario;
import com.example.Invenire.services.CategoriaService;
import com.example.Invenire.services.CursoService;
import com.example.Invenire.services.CursoUsuarioService;
import com.example.Invenire.services.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cursos")
public class CursoPageController {
    private CursoService servicio;
    @Autowired private UsuarioDetailsService userService;
    @Autowired private CursoUsuarioService cursoUsuarioService;
    @Autowired private CategoriaService categoriaService;
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
                                 Model model) {
        int pageSize = 6;
        Page<CursoUsuario> page = cursoUsuarioService.buscarCursoPorUsuarioPaginado(pageNo, pageSize,userService.obtenerUsuarioSesion());
        List<CursoCardDTO> listaCursos = new ArrayList<>();
        for(CursoUsuario c : page.getContent()){
            Curso curso = c.getCurso();
            CursoCardDTO cursoCardDTO = CursoCardDTO.builder()
                    .id(curso.getId())
                    .nombre(curso.getNombre())
                    .cantEstrellasDadas(curso.getCantEstrellas())
                    .cantEstrellasFaltantes(5-curso.getCantEstrellas())
                    .urlFotoCurso(curso.getUrlFotoCurso())
                    .nombreAutor(curso.getAutor().getNombre() + " " + curso.getAutor().getApellido())
                    .precio(curso.getPrecio())
                    .precioDescontado(curso.getPrecio() * (1 - curso.getPorcDescuento()))
                    .comprado(true)
                    .build();
            listaCursos.add(cursoCardDTO);
        }

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());


        model.addAttribute("listCursos", listaCursos);
        return "views/cursos/mis_cursos";
    }

    @GetMapping("/tienda/{pageNo}")
    public String mostrarTienda(@PathVariable (value = "pageNo") int pageNo, @ModelAttribute("searchDTO") SearchDTO searchDTO, Model model) {
        try{
            int pageSize = 6;
            Page<Curso> page = servicio.buscarCursosTienda(searchDTO,pageNo,pageSize);
            List<CursoCardDTO> listaCursos = new ArrayList<>();
            for(Curso curso : page.getContent()){
                CursoCardDTO cursoCardDTO = CursoCardDTO.builder()
                        .id(curso.getId())
                        .nombre(curso.getNombre())
                        .cantEstrellasDadas(curso.getCantEstrellas())
                        .cantEstrellasFaltantes(5-curso.getCantEstrellas())
                        .urlFotoCurso(curso.getUrlFotoCurso())
                        .nombreAutor(curso.getAutor().getNombre() + " " + curso.getAutor().getApellido())
                        .precio(curso.getPrecio())
                        .precioDescontado(curso.getPrecio() * (1 - curso.getPorcDescuento()))
                        .build();
                CursoUsuario cursoUsuario = cursoUsuarioService.findCursoUsuarioByCursoAndUsuario(curso,userService.obtenerUsuarioSesion());
                cursoCardDTO.setComprado(cursoUsuario != null);
                listaCursos.add(cursoCardDTO);
            }
            List<Categoria> categorias = categoriaService.findAll();
            model.addAttribute("categorias",categorias);
            SearchDTO search = new SearchDTO();
            model.addAttribute("searchDTO",search);
            model.addAttribute("currentCategoria",searchDTO.getCategoria());
            model.addAttribute("currentPage", pageNo);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalItems", page.getTotalElements());

            model.addAttribute("listCursos", listaCursos);
            return "views/cursos/tienda";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "redirect:/";
        }


    }


}
