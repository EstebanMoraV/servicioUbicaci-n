package com.grupo6.servicioUbicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo6.servicioUbicacion.model.UbicacionUsuario;

@Repository
public interface UbicacionUsuarioRepo extends JpaRepository<UbicacionUsuario, Integer> {

}
