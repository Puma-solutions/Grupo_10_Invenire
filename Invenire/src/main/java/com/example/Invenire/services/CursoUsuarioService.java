package com.example.Invenire.services;

import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.entities.entities.CursoUsuario;
import com.example.Invenire.entities.entities.Usuario;

public interface CursoUsuarioService extends BaseService<CursoUsuario,Long> {
    public CursoUsuario findCursoUsuarioByCursoAndUsuario(Curso curso, Usuario usuario);
}
