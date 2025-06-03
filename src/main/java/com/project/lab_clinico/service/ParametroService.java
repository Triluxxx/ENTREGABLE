package com.project.lab_clinico.service;

import com.project.lab_clinico.entity.ParametroEntity;

import java.util.List;

public interface ParametroService {
    List<ParametroEntity> findAll();
    ParametroEntity findById(Long id);
    ParametroEntity save(ParametroEntity parametro);
    void delete(Long id);
}
