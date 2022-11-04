package com.example.Invenire.entities.entities;

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
@Table(name="carrito")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Carrito extends Base{
    @Column(name="fechaCreacion")
    private Date fechaCreacion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_usuario")
    private Usuario usuario;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="carrito_cursos",joinColumns=@JoinColumn(name="carrito_id"),
            inverseJoinColumns = @JoinColumn(name="curso_id"))
    private List<Curso> cursos = new ArrayList<Curso>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_cupon")
    private CuponDescuento cuponDescuento;
}
