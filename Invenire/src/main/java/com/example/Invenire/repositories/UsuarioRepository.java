package com.example.Invenire.repositories;

import com.example.Invenire.entities.entities.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long>{
    public Usuario findByUsername(String username);
}
