package Service;
import java.util.List;//paquete que permite usar colleciones dinamicas de tipo List

import Model.Respuesta;//importa el objeto "Respuesta"
import Model.Usuario;//importa la entidad "Usuario"
import Repository.IUsuarioRepository;//importa el repositorio "IUsuarioRepository"
import org.springframework.beans.factory.annotation.Autowired;//paquete que me permite incluir la inyeccion de dependencias esta clase
import org.springframework.http.HttpStatus;//paquete que me permite manejar las respuestas HTTP en forma de codigo
import org.springframework.http.ResponseEntity;//paquete que me permite manejar el tipo de respuesta que va a estar relacionada con una entidad y representarla como una respuesta HTTP
import org.springframework.stereotype.Service;//paquete que permite el uso de esta clase como u compontente "Service" en el contexto de spring

@Service//en base a esta anotacion se define que esta clase es un servicio
/**
 * Clase para definir el servicio UsuarioService
 */
public class UsuarioService {

    @Autowired//mediante esta anotacion se inyectan las dependencias del contexto spring a esta clase
    private IUsuarioRepository repository;

    /**
     * Metodo que me da toda la lista de usuarios que hay en la base de datos
     * @return Todos los usuarios de la base de datos
     */
    public List<Usuario> getTodosLosUsuarios() {
        return repository.findAll();
    }

    /**
     * Metodo que me valida si existe un usuario
     * @param u el usuario el cual se va a validar
     * @return True si se encontro el usuario, False en caso contrario
     */
    public boolean encontrarUsuario(Usuario u){
        return repository.existByCorreoAndContrasenia(u.getCorreo(), u.getContrasenia());
    }

    /**
     * Metodo que me registra un usuario nuevo a la base de datos
     * @param u el profesor a registrar
     * @return ResponseEntity con informacion sobre el resultado del registro
     */
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