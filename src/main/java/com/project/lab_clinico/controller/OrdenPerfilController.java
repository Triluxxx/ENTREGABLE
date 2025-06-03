package com.project.lab_clinico.controller;

import com.project.lab_clinico.entity.OrdenPerfilEntity;
import com.project.lab_clinico.service.OrdenPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orden-perfil")
public class OrdenPerfilController {
    @Autowired
    private OrdenPerfilService ordenPerfilService;

    @PostMapping
    public ResponseEntity<OrdenPerfilEntity> crear(@RequestBody OrdenPerfilEntity ordenPerfil) {
        return ResponseEntity.ok(ordenPerfilService.crear(ordenPerfil));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenPerfilEntity> obtenerPorId(@PathVariable Long id) {
        return ordenPerfilService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<OrdenPerfilEntity> listarTodos() {
        return ordenPerfilService.listarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenPerfilEntity> actualizar(@PathVariable Long id, @RequestBody OrdenPerfilEntity ordenPerfil) {
        return ResponseEntity.ok(ordenPerfilService.actualizar(id, ordenPerfil));
    }

    @DeleteMapping("/por-orden/{id}")
    public ResponseEntity<Void> eliminarPorOrden(@PathVariable Long id) {
        ordenPerfilService.eliminarPorOrden(id); // ✅ ahora este método existe
        return ResponseEntity.noContent().build();
    }

}
