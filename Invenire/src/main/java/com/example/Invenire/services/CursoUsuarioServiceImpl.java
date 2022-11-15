package com.example.Invenire.services;


import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.entities.entities.CursoUsuario;
import com.example.Invenire.entities.entities.Usuario;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.CursoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoUsuarioServiceImpl extends BaseServiceImpl<CursoUsuario,Long> implements CursoUsuarioService{

    @Autowired
    private CursoUsuarioRepository cursoUsuarioRepository;
    public CursoUsuarioServiceImpl(BaseRepository<CursoUsuario, Long> baseRepository) {
        super(baseRepository);
    }
    public CursoUsuario findCursoUsuarioByCursoAndUsuario(Curso curso, Usuario usuario){
        return cursoUsuarioRepository.findCursoUsuarioByCursoAndUsuario(curso,usuario);
    }
    @Override
    public Page<CursoUsuario> buscarCursoPorUsuarioPaginado(int pageNo, int pageSize, Usuario usuario) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.cursoUsuarioRepository.findCursoUsuarioByUsuario(usuario,pageable);
    }
}
