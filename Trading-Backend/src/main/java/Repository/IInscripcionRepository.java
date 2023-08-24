package Repository;

import Model.Curso;
import Model.Inscripcion;
import Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInscripcionRepository extends JpaRepository<Inscripcion,Integer> {boolean existByUsuarioAndCurso(Usuario usuario, Curso curso);}
