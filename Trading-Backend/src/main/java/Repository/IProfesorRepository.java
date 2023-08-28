package Repository;

import Model.Profesor;//importa la entidad "Profesor"
import org.springframework.data.jpa.repository.JpaRepository;//paquete que aniade la opcion de convertir una interfz en un repositorio para mantener la persistencia
import org.springframework.stereotype.Repository;//paquete para definir esta interfaz como un repositorio

@Repository//anotacion para realizar cambios a una base de datos por medio de esta interfaz
/**
 * Interfaz que representa la persistencia de la entidad "Profesor"
 * Extiende el paquete "JpaRepository" para acceder a la tabla relacionada con la entidad Profesor usando el tipo de dato de su Id: Integer
 */
public interface IProfesorRepository extends JpaRepository<Profesor,Integer> {
    /**
     * Metodo sin cuerpo que me valida si existe un profesor con un correo y una contrasenia dados por parametro
     * @param correo Correo del profesor por validar
     * @param contrasenia Contrasenia del profesor por validar
     * @return True si el profesor existe, False en caso contrario
     */
    boolean existByCorreoAndContrasenia(String correo, String contrasenia);
}
