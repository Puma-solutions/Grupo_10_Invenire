package com.example.Invenire.services;

import com.example.Invenire.entities.Curso;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends BaseServiceImpl<Curso,Long> implements CursoService  {


    @Autowired
    private CursoRepository cursoRepository;
    public CursoServiceImpl(BaseRepository<Curso, Long> baseRepository) {
        super(baseRepository);
    }
}
