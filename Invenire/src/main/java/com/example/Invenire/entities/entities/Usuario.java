package com.example.Invenire.entities.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Builder
public class Usuario extends Base{
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="email")
    private String email;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="urlFotoPerfil")
    private String urlFotoPerfil;
    @Column(name="celular")
    private String celular;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_direccion")
    private Direccion direccion;

    @ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="usuarios_roles", joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<Role>();

}
