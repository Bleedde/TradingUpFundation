package com.trading.trading_up_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "estado_curso_1")
    private CursoEstado estadoCurso1;

    @Column(name = "estado_curso_2")
    private CursoEstado estadoCurso2;

    @Column(name = "estado_curso_3")
    private CursoEstado estadoCurso3;

    @Column(name = "estado_curso_4")
    private CursoEstado estadoCurso4;
}
