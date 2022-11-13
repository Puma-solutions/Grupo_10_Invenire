package com.example.Invenire.services;

import com.example.Invenire.entities.entities.Pais;

public interface PaisService extends BaseService<Pais,Long> {

    Pais findPaisByNombre(String filtro);
}
