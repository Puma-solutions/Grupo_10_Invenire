package com.example.Invenire.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
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
}
