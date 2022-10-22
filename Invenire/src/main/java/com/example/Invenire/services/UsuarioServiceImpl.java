package com.example.Invenire.services;


import com.example.Invenire.entities.Usuario;
import com.example.Invenire.repositories.BaseRepository;

public class UsuarioServiceImpl extends BaseServiceImpl<Usuario,Long> implements UsuarioService{

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository) {
        super(baseRepository);
    }
}
