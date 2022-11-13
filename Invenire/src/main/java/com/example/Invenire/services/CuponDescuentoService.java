package com.example.Invenire.services;

import com.example.Invenire.entities.entities.CuponDescuento;

import java.util.Optional;

public interface CuponDescuentoService extends BaseService<CuponDescuento,Long> {
    public Optional<CuponDescuento> findCuponDescuentoByCodigo(String codigo);
}
