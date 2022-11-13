package com.example.Invenire.services;

import com.example.Invenire.entities.entities.Pais;
import com.example.Invenire.entities.entities.Usuario;

public interface PaisService extends BaseService<Pais,Long> {

    Pais obtenerPaisSesion(String filtro);
}
