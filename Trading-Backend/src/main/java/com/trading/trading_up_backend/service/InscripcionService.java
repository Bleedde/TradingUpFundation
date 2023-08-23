package com.trading.trading_up_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trading.trading_up_backend.model.EstadoInscripcion;
import com.trading.trading_up_backend.model.Inscripcion;
import com.trading.trading_up_backend.repository.IInscripcionRepository;

@Service
public class InscripcionService {

    @Autowired
    private IInscripcionRepository repository;

    public EstadoInscripcion getEstadoCurso(Inscripcion usuarioInscrito){
        EstadoInscripcion estado = null;
        if(repository.existsById(usuarioInscrito.getIdUsuario())){
            estado = usuarioInscrito.getEstadoInscripcion();
        }
        return estado;
    }

    public void setEstadoCurso(EstadoInscripcion estadoACambiar, Inscripcion inscripcionPorCambairEstado){
        if(repository.existsById(inscripcionPorCambairEstado.getIdUsuario())){
            inscripcionPorCambairEstado.setEstadoCurso(estadoACambiar);
        }
    }
}
