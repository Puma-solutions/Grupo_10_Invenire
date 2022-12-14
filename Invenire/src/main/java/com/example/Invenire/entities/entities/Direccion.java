package com.example.Invenire.entities.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name="direccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Builder
public class Direccion extends Base{
    @Column(name="calle")
    private String calle;
    @Column(name="ciudad")
    private String ciudad;
    @Column(name="codPostal")
    private String codPostal;
    @Column(name="localidad")
    private String localidad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_pais")
    private Pais pais;
}
