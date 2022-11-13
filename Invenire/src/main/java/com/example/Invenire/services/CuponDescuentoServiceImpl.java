package com.example.Invenire.services;

import com.example.Invenire.entities.entities.CuponDescuento;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.CuponDescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuponDescuentoServiceImpl extends BaseServiceImpl<CuponDescuento,Long> implements CuponDescuentoService {

    @Autowired
    private CuponDescuentoRepository cuponDescuentoRepository;
    public CuponDescuentoServiceImpl(BaseRepository<CuponDescuento, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Optional<CuponDescuento> findCuponDescuentoByCodigo(String codigo) {
        return cuponDescuentoRepository.findCuponDescuentoByCodigo(codigo);
    }
}
