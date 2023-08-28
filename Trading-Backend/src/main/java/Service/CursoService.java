package Service;

import Model.Curso;//importa la entidad "Curso"
import Model.Respuesta;//importa el objeto "Respuesta"
import Repository.ICursoRepository;//importa el repositorio "ICursoRepository"
import org.springframework.beans.factory.annotation.Autowired;//paquete que me permite incluir la inyeccion de dependencias esta clase
import org.springframework.http.HttpStatus;//paquete que me permite manejar las respuestas HTTP en forma de codigo
import org.springframework.http.ResponseEntity;//paquete que me permite manejar el tipo de respuesta que va a estar relacionada con una entidad y representarla como una respuesta HTTP
import org.springframework.stereotype.Service;//paquete que permite el uso de esta clase como u compontente "Service" en el contexto de spring

import java.util.List;//paquete que permite usar colleciones dinamicas de tipo List

@Service//en base a esta anotacion se define que esta clase es un servicio
/**
 * Clase para definir el servicio CursoService
 */
public class CursoService {
    @Autowired//mediante esta anotacion se inyectan las dependencias del contexto spring a esta clase
    private ICursoRepository repository;

    /**
     * Metodo que me da toda la lista de cursos que hay en la base de datos
     * @return Todos los cursos de la base de datos
     */
    public List<Curso> getCursos(){
        return repository.findAll();
    }

    /**
     * Metodo que me valida si existe un curso
     * @param c el curso el cual se va a validar
     * @return True si se encontro el curso, False en caso contrario
     */
    public boolean encontrarCurso(Curso c){
        return repository.existById(c.getId());
    }

    /**
     * Metodo que me registra un curso nuevo a la base de datos
     * @param c el curso a registrar
     * @return ResponseEntity con informacion sobre el resultado del registro
     */
    public ResponseEntity<?> register(Curso c){
        try {
            if(!this.encontrarCurso(c)){
                this.repository.save(c);
                return ResponseEntity.ok(Respuesta.builder().respuesta("Curso registrado correctamente").estadoCodigo(HttpStatus.OK).mensaje("Curso registrado exitosamente!!"));
            }else {
                return ResponseEntity.ok(Respuesta.builder().respuesta("Curso existente").estadoCodigo(HttpStatus.OK).mensaje("El curso ya existe, intentalo de nuevo"));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(Respuesta.builder().respuesta("Error interno del sistema"));
        }
    }
}
