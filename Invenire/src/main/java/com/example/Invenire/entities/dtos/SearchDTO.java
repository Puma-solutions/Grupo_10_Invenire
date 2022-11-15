package com.example.Invenire.entities.dtos;

import lombok.Data;

@Data
public class SearchDTO {
    private String filtro;
    private String categoria;
    private String ordenamiento;
}
