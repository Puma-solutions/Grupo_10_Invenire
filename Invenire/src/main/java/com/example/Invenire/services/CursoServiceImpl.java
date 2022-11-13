package com.example.Invenire.services;

import com.example.Invenire.entities.dtos.CursoCardDTO;
import com.example.Invenire.entities.entities.Curso;
import com.example.Invenire.entities.entities.CursoUsuario;
import com.example.Invenire.entities.entities.Usuario;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl extends BaseServiceImpl<Curso,Long> implements CursoService  {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired private CursoUsuarioServiceImpl cursoUsuarioService;
    public CursoServiceImpl(BaseRepository<Curso, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Curso> search(String filtro) throws Exception {
        try{
            List<Curso> cursos = cursoRepository.search(filtro);
            return cursos;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Curso> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Curso> cursos = cursoRepository.search(filtro,pageable);
            return cursos;
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Curso> findByNombreContainsIgnoreCaseAndFechaBajaIsNull(String nombre){
        return cursoRepository.findByNombreContainsIgnoreCaseAndFechaBajaIsNull(nombre);
    }
    public List<CursoCardDTO> buscarCursosPorNombreYPorUsuario(String nombre, Usuario usuario){
        List<CursoCardDTO> cursosDto = new ArrayList<>();
        List<Curso> cursos = cursoRepository.findByNombreContainsIgnoreCaseAndFechaBajaIsNull(nombre);
        for(Curso curso :cursos){
            CursoCardDTO cardDTO = CursoCardDTO.builder()
                    .id(curso.getId())
                    .cantEstrellasDadas(curso.getCantEstrellas())
                    .cantEstrellasFaltantes(5-curso.getCantEstrellas())
                    .urlFotoCurso(curso.getUrlFotoCurso())
                    .precio(curso.getPrecio())
                    .nombreAutor(curso.getAutor().getNombre() + " "
                    + curso.getAutor().getApellido())
                    .nombre(curso.getNombre())
                    .precio(curso.getPrecio())
                    .precioDescontado(curso.getPrecio() * (1- curso.getPorcDescuento()))
                    .build();
            cursosDto.add(cardDTO);
            CursoUsuario cursoUsuario = cursoUsuarioService.findCursoUsuarioByCursoAndUsuario(curso,usuario);
            if(cursoUsuario != null) cardDTO.setComprado(true);
            else cardDTO.setComprado(false);
        }
        return cursosDto;
    }

    public Curso buscarCursoPorIdYUsuario(Long id, Usuario usuario){
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        Curso curso = cursoOptional.get();
        CursoUsuario cursoUsuario = cursoUsuarioService.findCursoUsuarioByCursoAndUsuario(curso,usuario);
        Curso cursoReturn = curso;
        if(cursoUsuario == null) cursoReturn.setDetalles(null);
        return cursoReturn;
    }

    @Override
    public Page<Curso> buscarCursoPorUsuarioPaginado(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.cursoRepository.findAll(pageable);
    }

}
