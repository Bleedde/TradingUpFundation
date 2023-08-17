package com.trading.trading_up_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "inscripciones")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Inscripccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Integer idInscripcion;

    @Column(name = "id_usuario")
    private Usuario idUsuario;

    @Column(name = "id_curso")
    private Curso idCurso;

    @Column(name = "estado_curso")
    private EstadoCurso estadoCurso;
}