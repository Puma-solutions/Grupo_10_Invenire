package com.example.Invenire.entities.entities;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Audited
@Data
@Entity
@Table(name="role")
public class Role extends Base{
    @Column(name="nombre",unique=true)
    private String nombre;
}
