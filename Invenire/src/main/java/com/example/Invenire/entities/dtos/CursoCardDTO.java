package com.example.Invenire.entities.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursoCardDTO {
    private Long id;
    private String nombre;
    private int cantEstrellasDadas;
    private int cantEstrellasFaltantes;
    private String urlFotoCurso;
    private String nombreAutor;
    private double precio;
    private double precioDescontado;
    private boolean comprado;
}
