package com.project.lab_clinico.controller;

import com.project.lab_clinico.entity.UnidadEntity;
import com.project.lab_clinico.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidades")
public class UnidadController {

    @Autowired
    private UnidadService unidadService;

    @GetMapping
    public List<UnidadEntity> getAllUnidades() {
        return unidadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadEntity> getUnidadById(@PathVariable Integer id) {
        return unidadService.findById(id)
                .map(unidad -> ResponseEntity.ok().body(unidad))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UnidadEntity createUnidad(@RequestBody UnidadEntity unidad) {
        return unidadService.save(unidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadEntity> updateUnidad(@PathVariable Integer id, @RequestBody UnidadEntity unidadDetails) {
        return unidadService.findById(id).map(unidad -> {
            unidad.setNombre(unidadDetails.getNombre());
            return ResponseEntity.ok(unidadService.save(unidad));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidad(@PathVariable Integer id) {
        return unidadService.findById(id).map(unidad -> {
            unidadService.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
