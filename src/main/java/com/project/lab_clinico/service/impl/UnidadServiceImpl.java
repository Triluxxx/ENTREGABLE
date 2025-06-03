package com.project.lab_clinico.service.impl;

import com.project.lab_clinico.entity.UnidadEntity;
import com.project.lab_clinico.repository.UnidadRepository;
import com.project.lab_clinico.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadServiceImpl implements UnidadService {

    @Autowired
    private UnidadRepository unidadRepository;

    @Override
    public List<UnidadEntity> findAll() {
        return unidadRepository.findAll();
    }

    @Override
    public Optional<UnidadEntity> findById(Integer id) {
        return unidadRepository.findById(id);
    }

    @Override
    public UnidadEntity save(UnidadEntity unidad) {
        return unidadRepository.save(unidad);
    }

    @Override
    public void deleteById(Integer id) {
        unidadRepository.deleteById(id);
    }
}
