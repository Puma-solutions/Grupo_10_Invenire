package com.example.Invenire.entities.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="fk_detalle")
    private CursoDetalle detalle;
}
