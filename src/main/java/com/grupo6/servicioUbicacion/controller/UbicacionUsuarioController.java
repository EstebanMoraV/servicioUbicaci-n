package com.grupo6.servicioUbicacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<UbicacionUsuario> getUbicacionUsuarioById(Integer id) {
        return ResponseEntity.ok(ubicacionUsuarioService.getUbicacionUsuarioById(id));
    }

    @PostMapping
    public ResponseEntity<UbicacionUsuario> createUbicacionUsuario(@RequestParam UbicacionUsuario ubicacionUsuario) {
        UbicacionUsuario createdUbicacionUsuario = ubicacionUsuarioService.saveUbicacionUsuario(ubicacionUsuario);
        return ResponseEntity.ok(createdUbicacionUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UbicacionUsuario> updateUbicacionUsuario(@RequestParam Integer id,
            @RequestParam UbicacionUsuario ubicacionUsuario) {
        UbicacionUsuario updatedUbicacionUsuario = ubicacionUsuarioService.saveUbicacionUsuario(ubicacionUsuario);
        return ResponseEntity.ok(updatedUbicacionUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUbicacionUsuario(@RequestParam Integer id) {
        ubicacionUsuarioService.deleteUbicacionUsuario(id);
        return ResponseEntity.ok("Ubicacion de usuario eliminada");
    }
}
