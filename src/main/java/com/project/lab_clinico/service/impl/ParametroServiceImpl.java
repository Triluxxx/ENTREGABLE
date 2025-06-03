package com.project.lab_clinico.service.impl;

import com.project.lab_clinico.entity.ParametroEntity;
import com.project.lab_clinico.repository.ParametroRepository;
import com.project.lab_clinico.service.ParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametroServiceImpl implements ParametroService {

    @Autowired
    private ParametroRepository parametroRepository;

    @Override
    public List<ParametroEntity> findAll() {
        return parametroRepository.findAll();
    }

    @Override
    public ParametroEntity findById(Long id) {
        return parametroRepository.findById(id).orElse(null);
    }

    @Override
    public ParametroEntity save(ParametroEntity parametro) {
        return parametroRepository.save(parametro);
    }

    @Override
    public void delete(Long id) {
        parametroRepository.deleteById(id);
    }
}
