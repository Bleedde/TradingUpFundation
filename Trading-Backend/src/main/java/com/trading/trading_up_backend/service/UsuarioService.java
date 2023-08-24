package com.trading.trading_up_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trading.trading_up_backend.model.Usuario;
import com.trading.trading_up_backend.repository.IUsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private IUsuarioRepository repository;

    public List<Usuario> getTodosLosUsuarios(){
        return repository.findAll();
    }

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
}
