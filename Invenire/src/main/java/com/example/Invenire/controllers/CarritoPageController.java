package com.example.Invenire.controllers;

import com.example.Invenire.entities.dtos.CarritoDTO;
import com.example.Invenire.entities.dtos.CursoDTO;
import com.example.Invenire.entities.entities.Carrito;
import com.example.Invenire.entities.entities.CuponDescuento;
import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.exceptions.CarritoException;
import com.example.Invenire.services.CarritoService;
import com.example.Invenire.services.CuponDescuentoService;
import com.example.Invenire.services.CursoService;
import com.example.Invenire.services.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("carrito")
public class CarritoPageController {
    private CarritoService servicio;
    @Autowired
    private UsuarioDetailsService userService;
    @Autowired
    private CuponDescuentoService cuponDescuentoService;
    @Autowired
    private CursoService cursoService;
    public CarritoPageController(CarritoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/")
    public String mostrarCarrito(Model modelo){
        Optional<Carrito> carritoOptional = servicio.findCarritoByUsuario(userService.obtenerUsuarioSesion());
        CarritoDTO carritoDTO = null;
        if(carritoOptional.isPresent()){
            double totalCarrito = 0;
            double totalCursos = 0;
            List<CursoDTO> cursosDTO = new ArrayList<CursoDTO>();
            for(Curso c : carritoOptional.get().getCursos()){
                CursoDTO cursoDTO = CursoDTO.builder()
                        .id(c.getId())
                        .nombre(c.getNombre())
                        .precio(c.getPrecio())
                        .precioConDescuento(c.getPrecio() * (1-c.getPorcDescuento()))
                        .build();
                cursosDTO.add(cursoDTO);
                totalCarrito += cursoDTO.getPrecioConDescuento();
                totalCursos += cursoDTO.getPrecio();
            }
            carritoDTO = CarritoDTO.builder()
                    .totalCarrito(totalCarrito)
                    .totalCursosConDescuento(totalCarrito)
                    .totalCursos(totalCursos)
                    .cupon(carritoOptional.get().getCuponDescuento())
                    .cursos(cursosDTO)
                    .build();
            if(carritoOptional.get().getCuponDescuento() != null){
                carritoDTO.setTotalCarritoConDescuento(totalCarrito * (1-carritoOptional.get().getCuponDescuento().getPorcDescuento()));
            }
            else carritoDTO.setTotalCarritoConDescuento(totalCarrito);

        }
        modelo.addAttribute("carrito",carritoDTO);
        return "views/carrito/carrito";
    }

    @GetMapping("/addCurso/{idCurso}")
    public String agregarCursoCarrito(@PathVariable Long idCurso, Model modelo){
        try{
            servicio.agregarCursoCarrito(cursoService.findById(idCurso),userService.obtenerUsuarioSesion());
            return "redirect:/carrito/?exito=Curso agregado correctamente";
        }
        catch(CarritoException e){
            return "redirect:/carrito/?error=" + e.getMessage();
        }
        catch(Exception e){
            return "redirect:/carrito/?error=Ocurrio un error";
        }
    }
    @GetMapping("/deleteCurso/{idCurso}")
    public String eliminarCursoCarrito(@PathVariable Long idCurso, Model modelo){
        try{
            servicio.deleteCursoCarrito(cursoService.findById(idCurso),userService.obtenerUsuarioSesion());
            return "redirect:/carrito/?exito=Curso eliminado correctamente";
        }
        catch(CarritoException e){
            return "redirect:/carrito/?error=" + e.getMessage();
        }
        catch(Exception e){
            return "redirect:/carrito/?error=Ocurrio un error";
        }
    }

    @GetMapping("/deleteCupon")
    public String eliminarCursoCarrito(Model modelo){
        try{
            servicio.deleteCuponCarrito(userService.obtenerUsuarioSesion());
            return "redirect:/carrito/?exito=Curso eliminado correctamente";
        }
        catch(Exception e){
            return "redirect:/carrito/?error=Ocurrio un error";
        }
    }

    @GetMapping("/addCupon")
    public String agregarCuponCarrito(@RequestParam("codigoCupon") String codigoCupon){
        try{
            Optional<CuponDescuento> cuponOptional = cuponDescuentoService.findCuponDescuentoByCodigo(codigoCupon);
            if(cuponOptional.isPresent()){
                servicio.agregarCuponCarrito(cuponOptional.get(),userService.obtenerUsuarioSesion());
                return "redirect:/carrito/?exitoCupon";
            }
            else{
                throw new CarritoException("No existe este cupon");
            }

        }
        catch(CarritoException e){
            return "redirect:/carrito/?errorCupon=" + e.getMessage();
        }
        catch(Exception e){
            return "redirect:/carrito/?error=Ocurrio un error";
        }

    }

    @GetMapping("/confirmarCompra")
    public String confirmarCompra(){
        try{
            servicio.confirmarCompra(userService.obtenerUsuarioSesion());
            return "redirect:/";
        }
        catch(CarritoException e){
            return "redirect:/carrito/?error=" + e.getMessage();
        }
        catch(Exception e){
            return "redirect:/carrito/?error=Ocurrio un error";
        }

    }
}
