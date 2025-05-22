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

import com.grupo6.servicioUbicacion.model.UbicacionUsuario;
import com.grupo6.servicioUbicacion.service.UbicacionUsuarioService;

@RestController
@RequestMapping("/api/v1/ubicacion/usuario")
public class UbicacionUsuarioController {

    @Autowired
    private UbicacionUsuarioService ubicacionUsuarioService;

    @GetMapping
    public ResponseEntity<List<UbicacionUsuario>> getAllUbicacionesUsuario() {
        return ResponseEntity.ok(ubicacionUsuarioService.getAllUbicacionesUsuario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbicacionUsuario> getUbicacionUsuarioById(@PathVariable Integer id) {
        Optional<UbicacionUsuario> ubicacionUsuario = ubicacionUsuarioService.getUbicacionUsuarioById(id);
        return ubicacionUsuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UbicacionUsuario> createUbicacionUsuario(@RequestBody UbicacionUsuario ubicacionUsuario) {
        UbicacionUsuario createdUbicacionUsuario = ubicacionUsuarioService.saveUbicacionUsuario(ubicacionUsuario);
        return ResponseEntity.ok(createdUbicacionUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UbicacionUsuario> updateUbicacionUsuario(@PathVariable Integer id, @RequestBody UbicacionUsuario ubicacionUsuario){
        Optional<UbicacionUsuario> existingUbicacionUsuario = ubicacionUsuarioService.getUbicacionUsuarioById(id);
        if (existingUbicacionUsuario.isPresent()) {
            ubicacionUsuario.setIdUbicacionUsuario(id);
            UbicacionUsuario updatedUbicacionUsuario = ubicacionUsuarioService.saveUbicacionUsuario(ubicacionUsuario);
            return ResponseEntity.ok(updatedUbicacionUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUbicacionUsuario(@PathVariable Integer id) {
        ubicacionUsuarioService.deleteUbicacionUsuario(id);
        return ResponseEntity.ok("Ubicacion de usuario eliminada");
    }
}
