package com.example.Invenire.repositories;

import com.example.Invenire.entities.entities.CuponDescuento;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuponDescuentoRepository extends BaseRepository<CuponDescuento,Long>{
    public Optional<CuponDescuento> findCuponDescuentoByCodigo(String codigo);
}
