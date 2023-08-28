package Model;

import java.util.List;//paquete que permite usar colleciones dinamicas de tipo List

import jakarta.persistence.*;//paquete para aniadir anotaciones para entender esta clase como entidad de una base de datos
import com.fasterxml.jackson.annotation.JsonManagedReference;//paquete que define las relaciones entre entidades en la base de datos
import lombok.*;//paquete para facilitar la escritura de codigo escribiendo grandes partes de codigo en base de anotaciones

@Entity//en base a una anotacion se define que esta clase representa una entidad
@Table(name = "cursos")//nombre de la tabla a la que hace referencia esta entidad en la base de datos
@Getter//usando el paquete lombok se agregan los getters
@Setter//usando el paquete lombok se agregan los setters
@AllArgsConstructor//se agregan todos los argumentos a un constructor
@NoArgsConstructor//se crea un constuctor sin ningun argumento
/**
 * Clase para definir la entidad "cursos"
 */
public class Curso {
    @Id//anotacion que identifica este atributo como el id clave primaria de una entidad en base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)//anotacion que define la forma en la que va a crecer este id a media que reciba registros en la base de datos
    @Column(name = "id_curso")//nombre de la columna que representa este atributo
    private Integer id;

    @Column(name = "nivel")//nombre de la columna que representa este atributo
    private Integer nivel;

    @Column(name = "descripcion")//nombre de la columna que representa este atributo
    private String descripcion;

    @OneToMany(mappedBy = "curso")//anotacion para definir la parte uno de una relacion uno a muchos y mapea el atributo que se encuentra en la otra entidad
    @JsonManagedReference//anotacion que permite evitar la recursion infinita entre las relaciones de entidades
    private List<Inscripcion> inscripciones;
}