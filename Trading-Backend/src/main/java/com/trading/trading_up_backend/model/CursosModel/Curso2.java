package com.trading.trading_up_backend.model.CursosModel;

import com.trading.trading_up_backend.model.Profesor;
import com.trading.trading_up_backend.model.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "curso_2")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso2 {
    
    @Id
    @Column(name = "nivel")
    private static final Integer NIVEL = 2;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "id_usuario")
    private Usuario idUsuario;

    @Column(name = "id_profesor")
    private Profesor idProfesor;
}
