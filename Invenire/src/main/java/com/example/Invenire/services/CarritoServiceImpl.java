package com.example.Invenire.services;


import com.example.Invenire.entities.Carrito;
import com.example.Invenire.repositories.BaseRepository;

public class CarritoServiceImpl extends BaseServiceImpl<Carrito,Long> implements CarritoService{

    public CarritoServiceImpl(BaseRepository<Carrito, Long> baseRepository) {
        super(baseRepository);
    }
}
