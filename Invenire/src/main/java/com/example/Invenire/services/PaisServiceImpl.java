package com.example.Invenire.services;

import com.example.Invenire.entities.entities.Pais;
import com.example.Invenire.entities.entities.Usuario;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl extends BaseServiceImpl<Pais,Long> implements PaisService{

    @Autowired
    private PaisRepository paisRepositorio;
    public PaisServiceImpl(BaseRepository<Pais, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Pais findPaisByNombre(String filtro) {
        Pais pais = paisRepositorio.findPaisByNombre(filtro);
        return pais;
    }
}
