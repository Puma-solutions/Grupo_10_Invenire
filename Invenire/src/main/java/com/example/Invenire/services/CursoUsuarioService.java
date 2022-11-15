package com.example.Invenire.services;

import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.entities.entities.CursoUsuario;
import com.example.Invenire.entities.entities.Usuario;
import org.springframework.data.domain.Page;

public interface CursoUsuarioService extends BaseService<CursoUsuario,Long> {
    public Page<CursoUsuario> buscarCursoPorUsuarioPaginado(int pageNo, int pageSize,Usuario usuario);
    public CursoUsuario findCursoUsuarioByCursoAndUsuario(Curso curso, Usuario usuario);
}
