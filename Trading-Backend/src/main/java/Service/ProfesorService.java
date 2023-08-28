package Service;
import java.util.List;//paquete que permite usar colleciones dinamicas de tipo List

import Model.Profesor;//importa la entidad "Profesor"
import Model.Respuesta;//importa el objeto "Respuesta"
import Repository.IProfesorRepository;//importa el repositorio "IProfesorRepository"
import org.springframework.beans.factory.annotation.Autowired;//paquete que me permite incluir la inyeccion de dependencias esta clase
import org.springframework.http.HttpStatus;//paquete que me permite manejar las respuestas HTTP en forma de codigo
import org.springframework.http.ResponseEntity;//paquete que me permite manejar el tipo de respuesta que va a estar relacionada con una entidad y representarla como una respuesta HTTP
import org.springframework.stereotype.Service;//paquete que permite el uso de esta clase como u compontente "Service" en el contexto de spring

@Service//en base a esta anotacion se define que esta clase es un servicio
/**
 * Clase para definir el servicio ProfesorService
 */
public class ProfesorService {

    @Autowired//mediante esta anotacion se inyectan las dependencias del contexto spring a esta clase
    private IProfesorRepository repository;

    /**
     * Metodo que me da toda la lista de profesores que hay en la base de datos
     * @return Todos los profesores de la base de datos
     */
    public List<Profesor> getTodosLosProfesores(){
        return repository.findAll();
    }

    /**
     * Metodo que me valida si existe un profesor
     * @param p el profesor el cual se va a validar
     * @return True si se encontro el profesor, False en caso contrario
     */
    public boolean encontrarProfesor(Profesor p){
        return repository.existByCorreoAndContrasenia(p.getCorreo(), p.getContrasenia());
    }

    /**
     * Metodo que me registra un profesor nuevo a la base de datos
     * @param p el profesor a registrar
     * @return ResponseEntity con informacion sobre el resultado del registro
     */
    public ResponseEntity<?> register(Profesor p){
        try {
            if(!encontrarProfesor(p)){
                this.repository.save(p);
                return ResponseEntity.ok(Respuesta.builder().respuesta("Profesor registrado correctamente").estadoCodigo(HttpStatus.OK).mensaje("Profesor registrado exitosamente!!"));
            }else {
                return ResponseEntity.ok(Respuesta.builder().respuesta("Profesor existente").estadoCodigo(HttpStatus.OK).mensaje("El profesor ya existe, intentelo de nuevo"));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(Respuesta.builder().respuesta("Error interno del sistema"));
        }
    }
}