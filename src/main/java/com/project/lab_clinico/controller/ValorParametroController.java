package com.project.lab_clinico.controller;

import com.project.lab_clinico.entity.ValorParametroEntity;
import com.project.lab_clinico.service.ValorParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valor_parametro")
@CrossOrigin(origins = "*")//esto puede ser riesgoso...!ATENCIÓN AQUI!
public class ValorParametroController {

    @Autowired
    private ValorParametroService valorParametroService;

    @GetMapping
    public List<ValorParametroEntity> getAllValores() {
        return valorParametroService.findAll();
    }

    @GetMapping("/{id}")
    public ValorParametroEntity getValorById(@PathVariable Long id) {
        return valorParametroService.findById(id);
    }

    @PostMapping
    public ValorParametroEntity createValor(@RequestBody ValorParametroEntity valorParametro) {
        return valorParametroService.save(valorParametro);
    }

    @PutMapping("/{id}")
    public ValorParametroEntity updateValor(@PathVariable Long id, @RequestBody ValorParametroEntity valorParametro) {
        ValorParametroEntity existing = valorParametroService.findById(id);
        if (existing != null) {
            valorParametro.setIdValorParametro(id);
            return valorParametroService.save(valorParametro);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteValor(@PathVariable Long id) {
        valorParametroService.delete(id);
    }
}
