package com.example.Invenire.services;


import com.example.Invenire.entities.Carrito;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceImpl extends BaseServiceImpl<Carrito,Long> implements CarritoService{

    @Autowired
    private CarritoRepository carritoRepository;
    public CarritoServiceImpl(BaseRepository<Carrito, Long> baseRepository) {
        super(baseRepository);
    }
}
