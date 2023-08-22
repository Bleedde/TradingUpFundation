package com.trading.trading_up_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "inscripciones")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Integer idInscripcion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso idCurso;

    @Column(name = "estado_inscripcion")
    private EstadoInscripcion estadoInscripcion;


    public Integer getIdUsuario(){
        return idUsuario.getId();
    }

    public Integer getIdCurso(){
        return idCurso.getIdCurso();
    }

    public EstadoInscripcion getEstadoInscripcion(){
        return this.estadoInscripcion;
    }
    public void setEstadoCurso(EstadoInscripcion nuevoEstado){
        this.estadoInscripcion = nuevoEstado;
    }
}