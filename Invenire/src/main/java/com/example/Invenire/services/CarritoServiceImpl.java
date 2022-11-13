package com.example.Invenire.services;


import com.example.Invenire.entities.entities.*;
import com.example.Invenire.exceptions.CarritoException;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CarritoServiceImpl extends BaseServiceImpl<Carrito,Long> implements CarritoService{

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired private CursoUsuarioService cursoUsuarioService;
    public CarritoServiceImpl(BaseRepository<Carrito, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public void agregarCursoCarrito(Curso curso, Usuario usuario) throws CarritoException {
        Optional<Carrito> carritoOptional = carritoRepository.findCarritoByUsuario(usuario);
        CursoUsuario cursoUsuario = cursoUsuarioService.findCursoUsuarioByCursoAndUsuario(curso,usuario);
        if(cursoUsuario != null) throw new CarritoException("No puedes agregar un curso que ya tienes");
        if(carritoOptional.isPresent()){
            carritoOptional.get().getCursos().add(curso);
            carritoRepository.save(carritoOptional.get());
        }
        else{
            Carrito carrito = new Carrito().builder()
                    .fechaCreacion(new Date())
                    .usuario(usuario)
                    .curso(curso)
            .build();
            carritoRepository.save(carrito);
        }

    }

    @Override
    public Optional<Carrito> findCarritoByUsuario(Usuario usuario) {
        return carritoRepository.findCarritoByUsuario(usuario);
    }

    @Override
    public void agregarCuponCarrito(CuponDescuento cupon, Usuario usuario) throws CarritoException {
        Optional<Carrito> carritoOptional = carritoRepository.findCarritoByUsuario(usuario);
        if(carritoOptional.isPresent()){
            if(cupon.getFechaDesde().before(new Date()) && cupon.getFechaHasta().after(new Date())){
                carritoOptional.get().setCuponDescuento(cupon);
                carritoRepository.save(carritoOptional.get());
            }
            else throw new CarritoException("Este cupon ya expiro.");
        }
    }

    @Override
    public void deleteCursoCarrito(Curso curso, Usuario usuario) throws CarritoException {
        //Traigo carrito
        Optional<Carrito> carritoOptional = carritoRepository.findCarritoByUsuario(usuario);
        if(carritoOptional.isPresent()){ //Si carrito no es null
            Carrito carrito = carritoOptional.get();
            //Me fijo si carrito contiene al curso
            if(carrito.getCursos().contains(curso)){
                //Si lo contiene lo elimino
                carrito.getCursos().remove(curso);
                if(!carrito.getCursos().isEmpty()){
                    //ahora reviso la lista de cursos, si la lista no esta vacia guardo el carrito, sino lo elimino.
                    carritoRepository.save(carrito);
                }
                else {
                    carritoRepository.delete(carrito);
                }
            }
            else throw new CarritoException("El carrito no incluye a este curso");
        }
    }

    @Override
    public void deleteCuponCarrito(Usuario usuario) {
        //Traigo carrito
        Optional<Carrito> carritoOptional = carritoRepository.findCarritoByUsuario(usuario);
        if(carritoOptional.isPresent()){ //Si carrito no es null
            Carrito carrito = carritoOptional.get();
            carrito.setCuponDescuento(null);
            carritoRepository.save(carrito);
        }


    }

    @Override
    public void confirmarCompra(Usuario usuario) throws CarritoException {
        try{
            //Traigo carrito
            Optional<Carrito> carritoOptional = carritoRepository.findCarritoByUsuario(usuario);
            if(carritoOptional.isPresent()){ //Si carrito no es null
                Carrito carrito = carritoOptional.get();
                if(carrito.getCursos().isEmpty()) throw new CarritoException("El carrito no contiene cursos");
                for(Curso c : carrito.getCursos()){
                    CursoUsuario cursoUsuario = new CursoUsuario();
                    cursoUsuario.setCurso(c);
                    cursoUsuario.setUsuario(usuario);
                    cursoUsuario.setFechaInicio(new Date());
                    cursoUsuarioService.save(cursoUsuario);
                }
                carritoRepository.delete(carrito);
            }
            else throw new CarritoException("El carrito no existe");
        }
        catch(Exception e) {

        }
    }
}
