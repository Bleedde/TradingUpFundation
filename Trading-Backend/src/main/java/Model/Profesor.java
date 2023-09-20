package Model;

import java.util.List;//paquete que permite usar colleciones dinamicas de tipo List

import com.fasterxml.jackson.annotation.JsonManagedReference;//paquete que define las relaciones entre entidades en la base de datos
import jakarta.persistence.*;//paquete para aniadir anotaciones para entender esta clase como entidad de una base de datos
import lombok.*;//paquete para facilitar la escritura de codigo escribiendo grandes partes de codigo en base de anotaciones

@Entity//en base a una anotacion se define que esta clase representa una entidad
@Table(name = "profesores")//nombre de la tabla a la que hace referencia esta entidad en la base de datos
@Setter//usando el paquete lombok se agregan los setters
@Getter//usando el paquete lombok se agregan los getters
@AllArgsConstructor//se agregan todos los argumentos a un constructor
@NoArgsConstructor//se crea un constuctor sin ningun argumento
/**
 * Clase para definir la entidad "profesores"
 */
public class Profesor{
    @Id//anotacion que identifica este atributo como el id clave primaria de una entidad en base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)//anotacion que define la forma en la que va a crecer este id a media que reciba registros en la base de datos
    @Column(name = "id_profesor")//nombre de la columna que representa este atributo
    private Integer idProfesor;

    @Column(name = "nombre")//nombre de la columna que representa este atributo
    private String nombre;

    @Column(name = "correo")//nombre de la columna que representa este atributo
    private String correo;

    @Column(name = "contrasenia")//nombre de la columna que representa este atributo
    private String contrasenia;

    @OneToMany(mappedBy = "idInscripcion")//anotacion para definir la parte uno de una relacion uno a muchos y mapea el atributo que se encuentra en la otra entidad
    @JsonManagedReference//anotacion que permite evitar la recursion infinita entre las relaciones de entidades
    private List<Inscripcion> inscripciones;
}