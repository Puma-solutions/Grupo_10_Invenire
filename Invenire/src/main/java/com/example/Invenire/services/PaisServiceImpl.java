package com.example.Invenire.services;

import com.example.Invenire.entities.entities.Pais;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl extends BaseServiceImpl<Pais,Long> implements PaisService{

    @Autowired
    private PaisRepository paisRepository;
    public PaisServiceImpl(BaseRepository<Pais, Long> baseRepository) {
        super(baseRepository);
    }
}
