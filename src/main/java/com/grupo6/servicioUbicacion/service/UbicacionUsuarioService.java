package com.grupo6.servicioUbicacion.service;

import java.util.List;

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

    public UbicacionUsuario getUbicacionUsuarioById(Integer id) {
        return ubicacionUsuarioRepo.findById(id).orElse(null);
    }

    public UbicacionUsuario saveUbicacionUsuario(UbicacionUsuario ubicacionUsuario) {
        return ubicacionUsuarioRepo.save(ubicacionUsuario);
    }

    public void deleteUbicacionUsuario(Integer id) {
        ubicacionUsuarioRepo.deleteById(id);
    }

}
