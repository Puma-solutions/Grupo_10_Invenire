package com.example.Invenire.repositories;

import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.entities.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long>{

    @Transactional
    public Usuario findByUsername(String username);
    @Transactional
    public Usuario findByEmail(String email);




}
