package com.grupo6.servicioUbicacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ubicacion_usuario")
@AllArgsConstructor
@NoArgsConstructor
public class UbicacionUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUbicacionUsuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(nullable=false)
    private Double latitud;

    @Column(nullable=false)
    private Double longitud;

    @Column(nullable=false, length=50)  
    private String ciudad;
}
