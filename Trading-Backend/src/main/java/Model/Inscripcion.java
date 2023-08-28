package Model;
import com.fasterxml.jackson.annotation.JsonBackReference;//paquete que define las relaciones entre entidades en la base de datos
import jakarta.persistence.*;//paquete para aniadir anotaciones para entender esta clase como entidad de una base de datos
import lombok.*;//paquete para facilitar la escritura de codigo escribiendo grandes partes de codigo en base de anotaciones

@Entity//en base a una anotacion se define que esta clase representa una entidad
@Table(name = "inscripciones")//nombre de la tabla a la que hace referencia esta entidad en la base de datos
@AllArgsConstructor//se agregan todos los argumentos a un constructor
@NoArgsConstructor//se crea un constuctor sin ningun argumento
@Setter//usando el paquete lombok se agregan los setters
@Getter//usando el paquete lombok se agregan los getters
/**
 * Clase para definir la entidad "inscripciones"
 */
public class Inscripcion {
    @Id//anotacion que identifica este atributo como el id clave primaria de una entidad en base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)//anotacion que define la forma en la que va a crecer este id a media que reciba registros en la base de datos
    @Column(name = "id_inscripcion")//nombre de la columna que representa este atributo
    private Integer idInscripcion;

    @ManyToOne//anotacion para definir la parte muchos de la relacion muchos a uno
    @JoinColumn(name = "id_usuario")//anotacion que permite mapear este atributo con una columna en una base de datos
    @JsonBackReference//anotacion que perite evitar el probelam de la recursion infinita ademas de definir que este lado de la relacion no debe ser serializado
    private Usuario usuario;

    @ManyToOne//anotacion para definir la parte muchos de la relacion muchos a uno
    @JoinColumn(name = "id_curso")//anotacion que permite mapear este atributo con una columna en una base de datos
    @JsonBackReference//anotacion que perite evitar el probelam de la recursion infinita ademas de definir que este lado de la relacion no debe ser serializado
    private Curso curso;

    @Column(name = "estado_inscripcion")//nombre de la columna que representa este atributo
    private EstadoInscripcion estadoInscripcion;

    /**
     * Metodo tipo Integer para obtener el atributo id de la entidad "Usuario"
     * @return id
     */
    public Integer getIdUsuario(){
        return usuario.getId();
    }

    /**
     * Metodo tipo Integer para obtener el atributo id de la entidad "Curso"
     * @return id
     */
    public Integer getIdCurso(){
        return curso.getId();
    }

    /**
     * Metodo de tipo void para cambiar el estado de un curso en una inscripcion
     * @param nuevoEstado el estado nuevo que va a obtener la inscripcion
     */
    public void setEstadoCurso(EstadoInscripcion nuevoEstado){
        this.estadoInscripcion = nuevoEstado;
    }
}