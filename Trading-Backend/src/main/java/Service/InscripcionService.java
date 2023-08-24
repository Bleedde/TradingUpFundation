package Service;

import Model.EstadoInscripcion;
import Model.Inscripcion;
import Repository.IInscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {
    @Autowired
    private IInscripcionRepository reposritory;

    public List<Inscripcion> inscripciones;

    public void cambiarEstadoInscripcion(Inscripcion inscripcion, EstadoInscripcion estadoNuevo){
        boolean inscripcionExistente = reposritory.existByUsuarioAndCurso(inscripcion.getUsuario(), inscripcion.getCurso());
        if(inscripcionExistente){
            inscripcion.setEstadoInscripcion(estadoNuevo);
        }
    }
}
