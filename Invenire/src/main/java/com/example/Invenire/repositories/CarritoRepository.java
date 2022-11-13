package com.example.Invenire.repositories;

import com.example.Invenire.entities.entities.Carrito;
import com.example.Invenire.entities.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarritoRepository extends BaseRepository<Carrito,Long>{
    public Optional<Carrito> findCarritoByUsuario(Usuario usuario);
}
