package com.example.Invenire.services;

import com.example.Invenire.entities.Curso;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl extends BaseServiceImpl<Curso,Long> implements CursoService  {

    @Autowired
    private CursoRepository cursoRepository;
    public CursoServiceImpl(BaseRepository<Curso, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Curso> search(String filtro) throws Exception {
        try{
            List<Curso> cursos = cursoRepository.search(filtro);
            return cursos;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Curso> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Curso> cursos = cursoRepository.search(filtro,pageable);
            return cursos;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
