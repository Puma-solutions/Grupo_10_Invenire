package com.example.Invenire.services;

import com.example.Invenire.entities.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CursoService extends BaseService<Curso,Long>{

    List<Curso> search(String filtro) throws Exception;
    Page<Curso> search(String filtro, Pageable pageable) throws Exception;

}
