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
@Table(name="carrito")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Carrito extends Base{
    @Column(name="fechaCreacion")
    private Date fechaCreacion;
}
