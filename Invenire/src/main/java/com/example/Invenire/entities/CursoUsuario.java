package com.example.Invenire.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="cursoUsuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class CursoUsuario extends Base{
    @Column(name="fechaInicio")
    private Date fechaInicio;
    @Column(name="fechaTerminacion")
    private Date fechaTerminacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CursoUsuarioDetalle> detalles = new ArrayList<CursoUsuarioDetalle>();

    @ManyToOne
    @JoinColumn(name="fk_curso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name="fk_usuario")
    private Usuario usuario;
}
