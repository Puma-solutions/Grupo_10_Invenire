package com.example.Invenire.services;


import com.example.Invenire.entities.Usuario;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario,Long> implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository) {
        super(baseRepository);
    }
}
