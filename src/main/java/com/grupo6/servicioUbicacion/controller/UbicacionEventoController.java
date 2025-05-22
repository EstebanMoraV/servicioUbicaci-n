package com.grupo6.servicioUbicacion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo6.servicioUbicacion.model.UbicacionEvento;
import com.grupo6.servicioUbicacion.service.UbicacionEventoService;

@RestController
@RequestMapping("/api/v1/ubicacion/evento")
public class UbicacionEventoController {

    @Autowired
    private UbicacionEventoService ubicacionEventoService;

    @GetMapping
    public ResponseEntity<List<UbicacionEvento>> getAllUbicacionesEvento() {
        return ResponseEntity.ok(ubicacionEventoService.getAllUbicacionesEvento());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbicacionEvento> getUbicacionEventoById(@PathVariable Integer id) {
        Optional<UbicacionEvento> ubicacionEvento = ubicacionEventoService.getUbicacionEventoById(id);
        return ubicacionEvento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UbicacionEvento> createUbicacionEvento(@RequestBody UbicacionEvento ubicacionEvento) {
        UbicacionEvento createdUbicacionEvento = ubicacionEventoService.saveUbicacionEvento(ubicacionEvento);
        return ResponseEntity.ok(createdUbicacionEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UbicacionEvento> updateUbicacionEvento(@PathVariable Integer id, @RequestBody UbicacionEvento ubicacionEvento) {
        Optional<UbicacionEvento> existingUbicacionEvento = ubicacionEventoService.getUbicacionEventoById(id);
        if (existingUbicacionEvento.isPresent()) {
            ubicacionEvento.setId(id);
            UbicacionEvento updatedUbicacionEvento = ubicacionEventoService.saveUbicacionEvento(ubicacionEvento);
            return ResponseEntity.ok(updatedUbicacionEvento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUbicacionEvento(@PathVariable Integer id) {
        ubicacionEventoService.deleteUbicacionEvento(id);
        return ResponseEntity.ok("Ubicacion de evento eliminada");
    }

}
