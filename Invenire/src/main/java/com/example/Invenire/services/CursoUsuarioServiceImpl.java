package com.example.Invenire.services;


import com.example.Invenire.entities.CursoUsuario;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.CursoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoUsuarioServiceImpl extends BaseServiceImpl<CursoUsuario,Long> implements CursoUsuarioService{

    @Autowired
    private CursoUsuarioRepository cursoUsuarioRepository;
    public CursoUsuarioServiceImpl(BaseRepository<CursoUsuario, Long> baseRepository) {
        super(baseRepository);
    }
}
