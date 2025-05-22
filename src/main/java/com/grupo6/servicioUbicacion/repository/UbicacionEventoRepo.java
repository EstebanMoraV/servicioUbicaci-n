package com.grupo6.servicioUbicacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo6.servicioUbicacion.model.UbicacionEvento;

@Repository
public interface UbicacionEventoRepo extends JpaRepository<UbicacionEvento, Integer> {
    @SuppressWarnings("override")
    Optional<UbicacionEvento> findById(Integer id);

}
