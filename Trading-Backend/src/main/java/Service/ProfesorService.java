package Service;
import java.util.List;

import Model.Profesor;
import Repository.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {

    @Autowired
    private IProfesorRepository repository;

    public List<Profesor> getTodosLosProfesores(){
        return repository.findAll();
    }

    public boolean encontrarProfesor(Profesor p){
        return repository.existByCorreoAndContrasenia(p.getCorreo(), p.getContrasenia());
    }


    public String register(Profesor p){
        if(!this.encontrarProfesor(p)){
            repository.save(p);
            return "Usuario registrado";
        }else{
            return "Usuario ya existente";
        }
    }
}