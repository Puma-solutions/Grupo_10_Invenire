package com.example.Invenire.services;

import com.example.Invenire.entities.dtos.CursoCardDTO;
import com.example.Invenire.entities.dtos.SearchDTO;
import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.entities.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CursoService extends BaseService<Curso,Long>{

    List<Curso> search(String filtro) throws Exception;
    Page<Curso> search(String filtro, Pageable pageable) throws Exception;

    public List<Curso> findByNombreContainsIgnoreCaseAndFechaBajaIsNull(String nombre);
    public List<CursoCardDTO> buscarCursosPorNombreYPorUsuario(String nombre, Usuario usuario);

    public Curso buscarCursoPorIdYUsuario(Long id, Usuario usuario);

    Page<Curso> buscarCursosTienda(SearchDTO searchDTO,int pageNo,int pageSize);

}
