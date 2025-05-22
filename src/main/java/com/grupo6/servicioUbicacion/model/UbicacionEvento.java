package com.grupo6.servicioUbicacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class UbicacionEvento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    @Column(nullable=false)
    private Double latitud;

    @Column(nullable=false)
    private Double longitud;

    @Column(nullable=false, length=50)
    private String ciudad;

}
