package com.example.Invenire.services;

import com.example.Invenire.entities.dtos.UsuarioEditDTO;
import com.example.Invenire.entities.dtos.UsuarioRegistroDTO;
import com.example.Invenire.entities.entities.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioDetailsService extends UserDetailsService {
    Usuario registerUser(UsuarioRegistroDTO registroDTO);
    Usuario obtenerUsuarioSesion();
    Usuario editUser(UsuarioEditDTO editDTO, Usuario userNativo);
}
