package com.example.Invenire.services;

import com.example.Invenire.entities.CuponDescuento;
import com.example.Invenire.repositories.BaseRepository;

public class CuponDescuentoServiceImpl extends BaseServiceImpl<CuponDescuento,Long> implements CuponDescuentoService {

    public CuponDescuentoServiceImpl(BaseRepository<CuponDescuento, Long> baseRepository) {
        super(baseRepository);
    }
}
