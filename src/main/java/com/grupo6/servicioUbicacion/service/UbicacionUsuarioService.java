package com.grupo6.servicioUbicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo6.servicioUbicacion.model.UbicacionUsuario;
import com.grupo6.servicioUbicacion.repository.UbicacionUsuarioRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UbicacionUsuarioService {

    @Autowired
    private UbicacionUsuarioRepo ubicacionUsuarioRepo;

    public List<UbicacionUsuario> getAllUbicacionesUsuario() {
        return ubicacionUsuarioRepo.findAll();
    }

    public Optional<UbicacionUsuario> getUbicacionUsuarioById(Integer id) {
        return ubicacionUsuarioRepo.findById(id);
    }

    public UbicacionUsuario saveUbicacionUsuario(UbicacionUsuario ubicacionUsuario) {
        return ubicacionUsuarioRepo.save(ubicacionUsuario);
    }

    public void deleteUbicacionUsuario(Integer id) {
        ubicacionUsuarioRepo.deleteById(id);
    }

}
