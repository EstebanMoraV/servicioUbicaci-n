package com.grupo6.servicioUbicacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo6.servicioUbicacion.model.UbicacionEvento;
import com.grupo6.servicioUbicacion.repository.UbicacionEventoRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UbicacionEventoService {

    @Autowired
    private UbicacionEventoRepo ubicacionEventoRepo;

    public List<UbicacionEvento> getAllUbicacionesEvento() {
        return ubicacionEventoRepo.findAll();
    }

    public Optional<UbicacionEvento> getUbicacionEventoById(Integer id) {
        return ubicacionEventoRepo.findById(id);
    }

    public UbicacionEvento saveUbicacionEvento(UbicacionEvento ubicacionEvento) {
        return ubicacionEventoRepo.save(ubicacionEvento);
    }
    
    public void deleteUbicacionEvento(Integer id) {
        ubicacionEventoRepo.deleteById(id);
    }

}
