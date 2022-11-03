package com.example.Invenire.entities.entities;

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
@Table(name="cuponDescuento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class CuponDescuento extends Base{
    @Column(name="codigo")
    private String codigo;
    @Column(name="fechaDesde")
    private Date fechaDesde;
    @Column(name="fechaHasta")
    private Date fechaHasta;
    @Column(name="porcDescuento")
    private double porcDescuento;
}
