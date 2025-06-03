package com.project.lab_clinico.controller;

import com.project.lab_clinico.entity.OrdenParametroEntity;
import com.project.lab_clinico.service.OrdenParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orden-parametro")
public class OrdenParametroController {

    @Autowired
    private OrdenParametroService ordenParametroService;

    @PostMapping
    public ResponseEntity<OrdenParametroEntity> crear(@RequestBody OrdenParametroEntity ordenParametro) {
        return ResponseEntity.ok(ordenParametroService.crear(ordenParametro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenParametroEntity> obtenerPorId(@PathVariable Long id) {
        return ordenParametroService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<OrdenParametroEntity> listarTodos() {
        return ordenParametroService.listarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenParametroEntity> actualizar(@PathVariable Long id, @RequestBody OrdenParametroEntity ordenParametro) {
        return ResponseEntity.ok(ordenParametroService.actualizar(id, ordenParametro));
    }

    @DeleteMapping("/por-orden/{idOrden}")
    public ResponseEntity<Void> eliminarPorOrden(@PathVariable Long idOrden) {
        ordenParametroService.eliminarPorOrden(idOrden); // solo delega, como debe ser
        return ResponseEntity.noContent().build();
    }




}


