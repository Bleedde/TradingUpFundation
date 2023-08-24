package Repository;

import Model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfesorRepository extends JpaRepository<Profesor,Integer> {boolean existByCorreoAndContrasenia(String correo, String contrasenia);}
