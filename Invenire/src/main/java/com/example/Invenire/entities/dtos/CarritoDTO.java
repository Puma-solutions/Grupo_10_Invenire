package com.example.Invenire.entities.dtos;

import com.example.Invenire.entities.entities.CuponDescuento;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CarritoDTO {
    private List<CursoDTO> cursos;
    private double totalCursos;
    private double totalCursosConDescuento;
    private double totalCarrito;
    private double totalCarritoConDescuento;
    private CuponDescuento cupon;
}
