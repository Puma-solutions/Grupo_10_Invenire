package com.example.Invenire.services;

import com.example.Invenire.entities.Curso;
import com.example.Invenire.repositories.BaseRepository;

public class CursoServiceImpl extends BaseServiceImpl<Curso,Long> implements CursoService  {


    public CursoServiceImpl(BaseRepository<Curso, Long> baseRepository) {
        super(baseRepository);
    }
}
