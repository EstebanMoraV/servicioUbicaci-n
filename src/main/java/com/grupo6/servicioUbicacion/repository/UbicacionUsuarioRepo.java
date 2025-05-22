package com.grupo6.servicioUbicacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo6.servicioUbicacion.model.UbicacionUsuario;

@Repository
public interface UbicacionUsuarioRepo extends JpaRepository<UbicacionUsuario, Integer> {
    @SuppressWarnings("override")
    Optional<UbicacionUsuario> findById(Integer id);
    

}
