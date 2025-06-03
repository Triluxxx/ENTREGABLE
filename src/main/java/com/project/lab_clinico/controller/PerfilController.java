package com.project.lab_clinico.controller;

import com.project.lab_clinico.dto.perfil.PerfilRequestDTO;
import com.project.lab_clinico.entity.PerfilEntity;
import com.project.lab_clinico.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/perfiles")
@CrossOrigin(origins = "*")//esto puede ser riesgoso...!ATENCIÓN AQUI!
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<PerfilEntity> listar() {
        return perfilService.listarPerfiles();
    }

    @GetMapping("/{id}")
    public Optional<PerfilEntity> obtenerPorId(@PathVariable Long id) {
        return perfilService.obtenerPerfilPorId(id);
    }

    @PostMapping
    public ResponseEntity<PerfilEntity> crear(@RequestBody PerfilRequestDTO dto) {
        PerfilEntity perfilCreado = perfilService.guardarPerfil(dto);
        return ResponseEntity.ok(perfilCreado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PerfilEntity> actualizar(@PathVariable Long id, @RequestBody PerfilRequestDTO dto) {
        PerfilEntity actualizado = perfilService.actualizarPerfil(id, dto);
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        perfilService.eliminarPerfil(id);
    }
}
