package Repository;

import Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {boolean existByCorreoAndContrasenia(String correo, String contrasenia);}
