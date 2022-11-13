package com.example.Invenire.services;

import com.example.Invenire.entities.entities.Carrito;
import com.example.Invenire.entities.entities.CuponDescuento;
import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.entities.entities.Usuario;
import com.example.Invenire.exceptions.CarritoException;

import java.util.Optional;

public interface CarritoService extends BaseService<Carrito,Long> {
    public void agregarCursoCarrito(Curso curso, Usuario usuario) throws CarritoException;
    public Optional<Carrito> findCarritoByUsuario(Usuario usuario);
    public void agregarCuponCarrito(CuponDescuento cupon,Usuario usuario) throws CarritoException;
    public void deleteCursoCarrito(Curso curso,Usuario usuario) throws CarritoException;
    public void deleteCuponCarrito(Usuario usuario);
    public void confirmarCompra(Usuario usuario) throws CarritoException;
}
