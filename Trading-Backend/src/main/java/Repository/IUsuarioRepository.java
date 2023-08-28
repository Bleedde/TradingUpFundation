package Repository;

import Model.Usuario;//importa la entidad "Usuario"
import org.springframework.data.jpa.repository.JpaRepository;//paquete que aniade la opcion de convertir una interfz en un repositorio para mantener la persistencia
import org.springframework.stereotype.Repository;//paquete para definir esta interfaz como un repositorio

@Repository//anotacion para realizar cambios a una base de datos por medio de esta interfaz
/**
 * Interfaz que representa la persistencia de la entidad "Usuario"
 * Extiende el paquete "JpaRepository" para acceder a la tabla relacionada con la entidad Usuario usando el tipo de dato de su Id: Integer
 */
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    /**
     * Metodo sin cuerpo que me valida si existe un usuario con un correo y una contrasenia dados por parametro
     * @param correo Correo del usuario por validar
     * @param contrasenia Contrasenia del usuario por validar
     * @return True si el usuario existe, False en caso contrario
     */
    boolean existByCorreoAndContrasenia(String correo, String contrasenia);
}
