package com.example.Invenire.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name="usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Usuario extends Base{
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="email")
    private String email;
    @Column(name="nombreUsuario")
    private String nombreUsuario;
    @Column(name="password")
    private String password;
    @Column(name="urlFotoPerfil")
    private String urlFotoPerfil;
    @Column(name="celular")
    private String celular;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_direccion")
    private Direccion direccion;
}
