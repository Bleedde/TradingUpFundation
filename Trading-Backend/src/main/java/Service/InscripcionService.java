package Service;

import Model.EstadoInscripcion;//importa la clase "EstadoInscripcion"
import Model.Inscripcion;//importa la entidad "Inscripcion"
import Model.Respuesta;
import Repository.IInscripcionRepository;//importa el repositorio "IInscripcionRepository"
import org.springframework.beans.factory.annotation.Autowired;//paquete que me permite incluir la inyeccion de dependencias esta clase
import org.springframework.http.HttpStatus;//paquete que me permite manejar las respuestas HTTP en forma de codigo
import org.springframework.http.ResponseEntity;//paquete que me permite manejar el tipo de respuesta que va a estar relacionada con una entidad y representarla como una respuesta HTTP
import org.springframework.stereotype.Service;//paquete que permite el uso de esta clase como u compontente "Service" en el contexto de spring

import java.util.List;//paquete que permite usar colleciones dinamicas de tipo List

@Service//en base a esta anotacion se define que esta clase es un servicio
/**
 * Clase para definir el servicio InscripcionService
 */
public class InscripcionService {
    @Autowired//mediante esta anotacion se inyectan las dependencias del contexto spring a esta clase
    private IInscripcionRepository reposritory;

    /**
     * Metodo que me da toda la lista de inscripciones que hay en la base de datos
     * @return Todas las inscripciones de la base de datos
     */
    public List<Inscripcion> inscripciones(){
        return this.reposritory.findAll();
    }

    /**
     * Metodo que me valida si existe una inscripcion
     * @param i el curso el cual se va a validar
     * @return True si se encontro la inscripcion, False en caso contrario
     */
    public boolean encontrarInscripcion(Inscripcion i){
        return this.reposritory.existById(i.getIdInscripcion());
    }

    /**
     * Metodo que me registra una nueva inscripcion a la base de datos
     * @param i Inscripcion por registrar
     * @return ResponseEntity con informacion sobre el resultado del registro
     */
    public ResponseEntity<?> register(Inscripcion i){
        try {
            if (!encontrarInscripcion(i)) {
                this.reposritory.save(i);
                return ResponseEntity.ok(Respuesta.builder().respuesta("Inscripcion registrada correctamente").estadoCodigo(HttpStatus.OK).mensaje("Inscripcion registrada exitosamente!!"));
            }else {
                return ResponseEntity.ok(Respuesta.builder().respuesta("Inscripcion ya existente").estadoCodigo(HttpStatus.OK).mensaje("Inscripcion ya registrada, porfavor intentelo de nuevo"));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(Respuesta.builder().respuesta("Error interno del sistema"));
        }
    }

    /**
     * Metodo que me cambia el estado de una inscripcion por uno nuevo que me llega por parametro
     * @param inscripcion La inscripcion a la cual se le quiere cambiar el estado
     * @param estadoNuevo El nuevo estado que va a adquirir la inscripcion
     */
    public void cambiarEstadoInscripcion(Inscripcion inscripcion, EstadoInscripcion estadoNuevo){
        boolean inscripcionExistente = this.encontrarInscripcion(inscripcion);
        if(inscripcionExistente){
            inscripcion.setEstadoInscripcion(estadoNuevo);
        }
    }
}
