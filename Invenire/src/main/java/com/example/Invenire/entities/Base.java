package com.example.Invenire.entities;

import lombok.*;

import javax . persistence.GeneratedValue ;
import javax.persistence.GenerationType;
import javax . persistence . Id ;
import javax.persistence.MappedSuperclass;
import java.io.Serializable ;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Base implements Serializable {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long id ;

}