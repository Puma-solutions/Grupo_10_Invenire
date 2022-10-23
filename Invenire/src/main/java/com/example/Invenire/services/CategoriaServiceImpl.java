package com.example.Invenire.services;


import com.example.Invenire.entities.Categoria;
import com.example.Invenire.repositories.BaseRepository;

public class CategoriaServiceImpl extends BaseServiceImpl<Categoria,Long> implements CategoriaService{

    public CategoriaServiceImpl(BaseRepository<Categoria, Long> baseRepository) {
        super(baseRepository);
    }
}
