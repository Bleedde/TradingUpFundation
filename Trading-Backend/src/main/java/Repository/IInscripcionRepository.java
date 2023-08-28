package Repository;

import Model.Curso;//importa la entidad "Curso"
import Model.Inscripcion;//importa la entidad "Inscripcion"
import Model.Usuario;//importa la entidad "Usuario"
import org.springframework.data.jpa.repository.JpaRepository;//paquete que aniade la opcion de convertir una interfz en un repositorio para mantener la persistencia
import org.springframework.stereotype.Repository;//paquete para definir esta interfaz como un repositorio

@Repository//anotacion para realizar cambios a una base de datos por medio de esta interfaz
/**
 * Interfaz que representa la persistencia de la entidad "Curso"
 * Extiende el paquete "JpaRepository" para acceder a la tabla relacionada con la entidad Inscripcion usando el tipo de dato de su Id: Integer
 */
public interface IInscripcionRepository extends JpaRepository<Inscripcion,Integer> {
    /**
     * Metodo sin cuerpo que me valida si existe una inscripcion con un Id dado por parametro
     * @param id Id de la inscripcion por validar
     * @return True si la inscripcion existe, False en caso contrario
     */
    boolean existById(Integer id);
}
