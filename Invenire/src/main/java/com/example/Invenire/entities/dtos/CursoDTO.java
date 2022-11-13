package com.example.Invenire.entities.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursoDTO {
    private Long id;
    private String nombre;
    private double precio;
    private double precioConDescuento;
}
