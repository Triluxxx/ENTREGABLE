package com.project.lab_clinico.controller;

import com.project.lab_clinico.entity.AreaEntity;
import com.project.lab_clinico.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping
    public List<AreaEntity> getAllAreas() {
        return areaService.findAll();
    }

    @GetMapping("/{id}")
    public AreaEntity getAreaById(@PathVariable Long id) {
        return areaService.findById(id);
    }

    @PostMapping
    public AreaEntity createArea(@RequestBody AreaEntity area) {
        return areaService.save(area);
    }

    @PutMapping("/{id}")
    public AreaEntity updateArea(@PathVariable Long id, @RequestBody AreaEntity updatedArea) {
        AreaEntity area = areaService.findById(id);
        if (area != null) {
            area.setNombre(updatedArea.getNombre());
            return areaService.save(area);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteArea(@PathVariable Long id) {
        areaService.deleteById(id);
    }
}
