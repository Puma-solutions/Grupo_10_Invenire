package com.example.Invenire.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cursoUsuarioDetalle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class CursoUsuarioDetalle extends Base{
    @Column(name="visto")
    private boolean visto;
}
