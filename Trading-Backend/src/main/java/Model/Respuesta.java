package Model;

import lombok.*;//paquete para facilitar la escritura de codigo escribiendo grandes partes de codigo en base de anotaciones
import org.springframework.http.HttpStatus;//paquete para generar en codigo respuestas HTTP

import java.io.Serializable;//paquete para indicar que los datos de esta clase pueden ser serializabes y ser convertidos a datos

@Data//anotacion para generar todo el codigo repetitivo en una clase normal java
@AllArgsConstructor//se agregan todos los argumentos a un constructor
@NoArgsConstructor//se crea un constuctor sin ningun argumento
@ToString//genera automaticamente el toString en una clase
@Builder//genera el patron de disenio builder para poder manejar objetos con gran numeros de respuestas opcionales
/**
 * Clase que representa una respuesta de cualquier tipo
 */
public class Respuesta implements Serializable {
    public HttpStatus estadoCodigo;
    public Object respuesta;
    public String mensaje;
}
