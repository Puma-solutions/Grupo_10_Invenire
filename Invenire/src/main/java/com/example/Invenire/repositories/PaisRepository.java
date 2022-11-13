package com.example.Invenire.repositories;

import com.example.Invenire.entities.entities.Pais;
import com.example.Invenire.entities.entities.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends BaseRepository<Pais,Long>{
    public Pais findPaisByNombre(String nombre);
}
