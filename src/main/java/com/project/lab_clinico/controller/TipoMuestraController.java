package com.project.lab_clinico.controller;

import com.project.lab_clinico.entity.TipoMuestraEntity;
import com.project.lab_clinico.service.TipoMuestraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-muestra")
public class TipoMuestraController {
    @Autowired
    private TipoMuestraService tipoMuestraService;

    @PostMapping
    public ResponseEntity<TipoMuestraEntity> crear(@RequestBody TipoMuestraEntity tipoMuestra) {
        TipoMuestraEntity nuevo = tipoMuestraService.crear(tipoMuestra);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping
    public List<TipoMuestraEntity> listarTodos() {
        return tipoMuestraService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMuestraEntity> obtenerPorId(@PathVariable Long id) {
        return tipoMuestraService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoMuestraEntity> actualizar(@PathVariable Long id, @RequestBody TipoMuestraEntity tipoMuestra) {
        TipoMuestraEntity actualizado = tipoMuestraService.actualizar(id, tipoMuestra);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tipoMuestraService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
