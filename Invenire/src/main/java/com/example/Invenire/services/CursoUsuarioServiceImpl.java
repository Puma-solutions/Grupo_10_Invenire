package com.example.Invenire.services;


import com.example.Invenire.entities.CursoUsuario;
import com.example.Invenire.repositories.BaseRepository;

public class CursoUsuarioServiceImpl extends BaseServiceImpl<CursoUsuario,Long> implements CursoUsuarioService{

    public CursoUsuarioServiceImpl(BaseRepository<CursoUsuario, Long> baseRepository) {
        super(baseRepository);
    }
}
