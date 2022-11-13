package com.example.Invenire.entities.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    @NotEmpty(message = "Debe completar este campo")
    @NotBlank
    private String nombre;

    @Column(name="apellido")
    @NotEmpty(message = "Debe completar este campo")
    @NotBlank
    private String apellido;

    @Column(name="email")
    @Email
    @NotEmpty(message = "Debe completar este campo")
    private String email;

    @Column(name="username")
    @NotEmpty(message = "Debe completar este campo")
    @NotBlank
    private String username;

    @Column(name="password")
    @Size(min = 1,max = 8,message = "La contraseña debe tener entre 1 y 8 caracteres")
    private String password;

    @Column(name="urlFotoPerfil")
    private String urlFotoPerfil;

    @Column(name="celular")
    @NotEmpty(message = "Debe completar este campo")
    @Size(max=15)
    private String celular;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_direccion")
    @NotNull
    private Direccion direccion;

    @ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="usuarios_roles", joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    @NotNull
    private List<Role> roles = new ArrayList<Role>();

}
