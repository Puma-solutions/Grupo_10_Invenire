package com.example.Invenire.services;


import com.example.Invenire.entities.Direccion;
import com.example.Invenire.repositories.BaseRepository;

public class DireccionServiceImpl extends BaseServiceImpl<Direccion,Long> implements DireccionService{

    public DireccionServiceImpl(BaseRepository<Direccion, Long> baseRepository) {
        super(baseRepository);
    }
}
