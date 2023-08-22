package com.trading.trading_up_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trading.trading_up_backend.model.EstadoInscripcion;
import com.trading.trading_up_backend.model.Inscripcion;
import com.trading.trading_up_backend.model.Usuario;
import com.trading.trading_up_backend.repository.IUsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private IUsuarioRepository repository;

    public List<Usuario> getTodosLosUsuarios(){
        return repository.findAll();
    }

    public String login(Usuario nuevoUsuario){
        boolean usuarioExistente = repository.existByCorreoAndContrasenia(nuevoUsuario.getCorreo(), nuevoUsuario.getContrasenia());
        if(usuarioExistente){
            return"Usuario encontrado, logeado exitosamente";
        }else{
            return "Usuario no encontrado";
        } 
    }

    public String register(Usuario nuevoUsuario){
        if(repository.findById(nuevoUsuario.getId()) == null){
            repository.save(nuevoUsuario);
            return "Usuario registrado";
        }else{
            return "Usuario ya existente";
        }
    }

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
