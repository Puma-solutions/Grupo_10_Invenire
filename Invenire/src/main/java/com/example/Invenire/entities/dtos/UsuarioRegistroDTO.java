package com.example.Invenire.entities.dtos;

import lombok.Data;

@Data
public class UsuarioRegistroDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String password;
    private String celular;
}
