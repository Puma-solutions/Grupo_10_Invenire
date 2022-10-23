package com.example.Invenire.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Categoria extends Base{
    @Column(name="nombre")
    private String nombre;
}
