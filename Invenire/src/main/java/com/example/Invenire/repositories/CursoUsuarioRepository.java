package com.example.Invenire.repositories;

import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.entities.entities.CursoUsuario;
import com.example.Invenire.entities.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoUsuarioRepository extends BaseRepository<CursoUsuario,Long>{
    public Page<CursoUsuario> findCursoUsuarioByUsuario(Usuario usuario, Pageable pageable);
    public CursoUsuario findCursoUsuarioByCursoAndUsuario(Curso curso,Usuario usuario);
}
