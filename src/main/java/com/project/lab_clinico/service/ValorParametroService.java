package com.project.lab_clinico.service;

import com.project.lab_clinico.entity.ValorParametroEntity;

import java.util.List;

public interface ValorParametroService {
    List<ValorParametroEntity> findAll();
    ValorParametroEntity findById(Long id);
    ValorParametroEntity save(ValorParametroEntity valorParametro);
    void delete(Long id);
}
