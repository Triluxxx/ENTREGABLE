package com.project.lab_clinico.controller;

import com.project.lab_clinico.dto.ordenes.OrdenRequestDTO;
import com.project.lab_clinico.dto.ordenes.OrdenResponseDTO;
import com.project.lab_clinico.dto.ordenes.OrdenUpdateDTO;
import com.project.lab_clinico.entity.OrdenesEntity;
import com.project.lab_clinico.service.OrdenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/ordenes")
public class OrdenesController {
    @Autowired
    private OrdenesService ordenesService;

    @PostMapping
    public ResponseEntity<OrdenesEntity> crearOrden(@RequestBody OrdenRequestDTO dto) {
        return ResponseEntity.ok(ordenesService.crearOrden(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenResponseDTO> obtenerOrden(@PathVariable Long id) {
        try {
            OrdenResponseDTO dto = ordenesService.obtenerOrdenDTOporId(id);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/laboratorista/{idLaboratorista}")
    public ResponseEntity<List<OrdenResponseDTO>> listarOrdenesPorLaboratorista(@PathVariable Long idLaboratorista) {
        List<OrdenResponseDTO> ordenes = ordenesService.listarOrdenesPorLaboratorista(idLaboratorista);
        return ResponseEntity.ok(ordenes);
    }

    @GetMapping
    public List<OrdenesEntity> listarOrdenes() {
        return ordenesService.listarTodas();
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrdenesEntity> actualizarOrden(@PathVariable Long id, @RequestBody OrdenUpdateDTO dto) {
        return ResponseEntity.ok(ordenesService.actualizarOrden(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable Long id) {
        ordenesService.eliminarOrden(id);
        return ResponseEntity.noContent().build();
    }
}
