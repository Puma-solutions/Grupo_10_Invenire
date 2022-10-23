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
@Table(name="direccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Direccion extends Base{
    @Column(name="calle")
    private String calle;
    @Column(name="ciudad")
    private String ciudad;
    @Column(name="codPostal")
    private int codPostal;
    @Column(name="localidad")
    private String localidad;
    @Column(name="pais")
    private String pais;
}
