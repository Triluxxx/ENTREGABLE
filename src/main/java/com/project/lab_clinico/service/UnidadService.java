package com.project.lab_clinico.service;

import com.project.lab_clinico.entity.UnidadEntity;

import java.util.List;
import java.util.Optional;

public interface UnidadService {
    List<UnidadEntity> findAll();
    Optional<UnidadEntity> findById(Integer id);
    UnidadEntity save(UnidadEntity unidad);
    void deleteById(Integer id);
}
