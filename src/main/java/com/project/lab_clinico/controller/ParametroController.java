package com.project.lab_clinico.controller;

import com.project.lab_clinico.entity.ParametroEntity;
import com.project.lab_clinico.service.ParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parametros")
@CrossOrigin(origins = "*")                               // esto puede ser riesgoso...!ATENCIÓN AQUI!
public class ParametroController {

    @Autowired
    private ParametroService parametroService;

    @GetMapping
    public List<ParametroEntity> getAllParametros() {
        return parametroService.findAll();
    }

    @GetMapping("/{id}")
    public ParametroEntity getParametroById(@PathVariable Long id) {
        return parametroService.findById(id);
    }

    @PostMapping
    public ParametroEntity createParametro(@RequestBody ParametroEntity parametro) {
        return parametroService.save(parametro);
    }

    @PutMapping("/{id}")
    public ParametroEntity updateParametro(@PathVariable Long id, @RequestBody ParametroEntity parametro) {
        ParametroEntity existing = parametroService.findById(id);
        if (existing != null) {
            parametro.setIdParametro(id);
            return parametroService.save(parametro);
        } else {
            return null;
        }
    }
    @DeleteMapping("/{id}")
    public void deleteParametro(@PathVariable Long id) {
        parametroService.delete(id);
    }
}
