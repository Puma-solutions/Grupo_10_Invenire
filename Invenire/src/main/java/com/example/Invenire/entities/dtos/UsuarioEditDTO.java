package com.example.Invenire.entities.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
public class UsuarioEditDTO {
    private String username;
    private String email;
    private String celular;
    private String fechaNacimiento;
    private String pais;
    private String localidad;
    private String ciudad;
    private String calle;
    private String codPostal;
}
