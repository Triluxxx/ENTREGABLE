package com.project.lab_clinico.controller;

import com.project.lab_clinico.entity.PerfilParametroEntity;
import com.project.lab_clinico.service.PerfilParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/perfil_parametro")
@CrossOrigin(origins = "*")//esto puede ser riesgoso...!ATENCIÓN AQUI!
public class PerfilParametroController {

    @Autowired
    private PerfilParametroService service;

    @GetMapping
    public List<PerfilParametroEntity> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<PerfilParametroEntity> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public PerfilParametroEntity guardar(@RequestBody PerfilParametroEntity perfilParametro) {
        return service.guardar(perfilParametro);
    }

    @PutMapping("/{id}")
    public PerfilParametroEntity actualizar(@PathVariable Integer id, @RequestBody PerfilParametroEntity perfilParametro) {
        return service.actualizar(id, perfilParametro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
