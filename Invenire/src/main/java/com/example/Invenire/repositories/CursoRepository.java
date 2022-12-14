package com.example.Invenire.repositories;

import com.example.Invenire.entities.entities.Categoria;
import com.example.Invenire.entities.entities.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends BaseRepository<Curso,Long>{
    @Query(
            value="Select * from curso where curso.nombre Like %:filtro% ",
            nativeQuery = true
    )
    List<Curso> search(@Param("filtro") String filtro);
    @Query(
            value="Select * from curso where curso.nombre Like %:filtro% ",
            nativeQuery = true,
            countQuery = "SELECT count (*) from curso"
    )
    Page<Curso> search(@Param("filtro") String filtro, Pageable pageable);

    List<Curso> findByNombreContainsIgnoreCaseAndFechaBajaIsNull(String nombre);

    Page<Curso> findCursoByCategoria(Categoria categoria,Pageable pageable);
}
