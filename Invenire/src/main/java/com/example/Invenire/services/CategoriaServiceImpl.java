package com.example.Invenire.services;


import com.example.Invenire.entities.entities.Categoria;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria,Long> implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;
    public CategoriaServiceImpl(BaseRepository<Categoria, Long> baseRepository) {
        super(baseRepository);
    }
}
