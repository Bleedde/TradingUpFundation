package Model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Respuesta implements Serializable {
    public HttpStatus estadoCodigo;
    public Object respuesta;
    public String mensaje;
}
