package com.example.Invenire.services;


import com.example.Invenire.entities.Direccion;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionServiceImpl extends BaseServiceImpl<Direccion,Long> implements DireccionService{

    @Autowired
    private DireccionRepository direccionRepository;
    public DireccionServiceImpl(BaseRepository<Direccion, Long> baseRepository) {
        super(baseRepository);
    }
}
