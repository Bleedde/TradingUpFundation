package com.trading.trading_up_backend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "username", nullable = false, length = 255)
    private String username;

    @Column(name = "correo", nullable = false, length = 255)
    private String correo;

    @Column(name = "contrasenia", nullable = false, length = 255)
    private String contrasenia;

    @OneToMany(mappedBy = "idInscripcion")
    private List<Inscripcion> inscripciones;

    public Integer getId(){
        return this.idUsuario;
    }
}