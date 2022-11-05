package com.example.Invenire.entities.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Curso extends Base{

    @Column(name="nombre")
    private String nombre;
    @Column(name="fechaBaja")
    private Date fechaBaja;
    @Column(name="fechaCreacion")
    private Date fechaCreacion;
    @Column(name="cantEstrellas")
    private int cantEstrellas;
    @Column(name="porcDescuento")
    private double porcDescuento;
    @Column(name="precio")
    private double precio;
    @Column(name="urlFotoCurso")
    private String urlFotoCurso;
    @Column(name="descripcion")
    private String descripcion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_categoria")
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="autor")
    private Usuario autor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CursoDetalle> detalles = new ArrayList<CursoDetalle>();
}
