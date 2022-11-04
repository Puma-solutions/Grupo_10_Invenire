package com.example.Invenire.services;
import com.example.Invenire.entities.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;


public interface BaseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception;            //Trae una lista de todas las personas (entidades)
    public Page<E> findAll(Pageable pageable) throws Exception;
    public E findById(ID id) throws Exception;          //Trae una persona o entidad de acuerdo a su id
    public E save(E entity) throws Exception;             //Crea uan entidad
    public E update(ID id, E entity) throws Exception;  //Actualiza una entidad
    public boolean delete(ID id) throws Exception;      //Elimina un registro de la base de datos
}
