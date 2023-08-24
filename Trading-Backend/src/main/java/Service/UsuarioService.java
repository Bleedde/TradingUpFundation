package Service;
import java.util.List;

import Model.Inscripcion;
import Model.Respuesta;
import Model.Usuario;
import Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository repository;

    public List<Usuario> getTodosLosUsuarios(){
        return repository.findAll();
    }

    public boolean encontrarUsuario(Usuario u){
        return repository.existByCorreoAndContrasenia(u.getCorreo(), u.getContrasenia());
    }

    public ResponseEntity<?> register(Usuario u){
        try {
            if(!this.encontrarUsuario(u)){
                this.repository.save(u);
                return ResponseEntity.ok(Respuesta.builder().respuesta("Usuario registrado correctamente").estadoCodigo(HttpStatus.OK).mensaje("Usuario registrado exitosamente!!"));
            }else{
                return ResponseEntity.ok(Respuesta.builder().respuesta("Usuario existente").estadoCodigo(HttpStatus.OK).mensaje("El usuario ya existe, intentalo de nuevo"));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(Respuesta.builder().respuesta("Error interno del sistema"));
        }
    }
}