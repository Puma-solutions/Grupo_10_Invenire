package com.example.Invenire.repositories;

import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.entities.entities.CursoUsuario;
import com.example.Invenire.entities.entities.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoUsuarioRepository extends BaseRepository<CursoUsuario,Long>{
    public CursoUsuario findCursoUsuarioByCursoAndUsuario(Curso curso, Usuario usuario);
}
