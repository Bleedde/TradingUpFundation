package Service;

import Model.Curso;
import Model.Profesor;
import Repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private ICursoRepository repository;

    public List<Curso> getCursos(){
        return repository.findAll();
    }

    public boolean encontrarCurso(Curso c){
        return repository.existById(c.getId());
    }


    public String register(Curso c){
        if(!this.encontrarCurso(c)){
            repository.save(c);
            return "Usuario registrado";
        }else{
            return "Usuario ya existente";
        }
    }
}
