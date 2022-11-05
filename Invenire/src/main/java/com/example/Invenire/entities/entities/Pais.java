package com.example.Invenire.entities.entities;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pais")
@Data
@Audited
public class Pais extends Base{
    @Column(name="nombre")
    private String nombre;
}
