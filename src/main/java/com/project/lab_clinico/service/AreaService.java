package com.project.lab_clinico.service;

import com.project.lab_clinico.entity.AreaEntity;

import java.util.List;

public interface AreaService {
    List<AreaEntity> findAll();
    AreaEntity findById(Long id);
    AreaEntity save(AreaEntity area);
    void deleteById(Long id);
}
