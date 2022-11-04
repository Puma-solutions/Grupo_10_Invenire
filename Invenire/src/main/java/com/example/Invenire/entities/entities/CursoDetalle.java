package com.example.Invenire.entities.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cursoDetalle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class CursoDetalle extends Base{
    @Column(name="numCap")
    private int numCap;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="linkVideo")
    private String linkVideo;

}
