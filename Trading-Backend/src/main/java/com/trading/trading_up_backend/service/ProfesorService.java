package com.trading.trading_up_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trading.trading_up_backend.model.Profesor;
import com.trading.trading_up_backend.repository.IProfesorRepository;

@Service
public class ProfesorService {
    
    @Autowired
    private IProfesorRepository repository;

    public List<Profesor> getTodosLosUsuarios(){
        return repository.findAll();
    }

    /* 
    public boolean login(Usuario nuevoUsuario){
        boolean usuarioExistente = repository.existByCorreoAndContrasenia(nuevoUsuario.getCorreo(), nuevoUsuario.getContrasenia());
        if(usuarioExistente){
            return true;
        }else{
            return false;
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
    */
}
