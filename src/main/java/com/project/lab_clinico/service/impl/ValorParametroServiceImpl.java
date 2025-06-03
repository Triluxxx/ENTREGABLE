package com.project.lab_clinico.service.impl;

import com.project.lab_clinico.entity.ValorParametroEntity;
import com.project.lab_clinico.repository.ValorParametroRepository;
import com.project.lab_clinico.service.ValorParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValorParametroServiceImpl implements ValorParametroService {

    @Autowired
    private ValorParametroRepository valorParametroRepository;

    @Override
    public List<ValorParametroEntity> findAll() {
        return valorParametroRepository.findAll();
    }

    @Override
    public ValorParametroEntity findById(Long id) {
        return valorParametroRepository.findById(id).orElse(null);
    }

    @Override
    public ValorParametroEntity save(ValorParametroEntity valorParametro) {
        return valorParametroRepository.save(valorParametro);
    }

    @Override
    public void delete(Long id) {
        valorParametroRepository.deleteById(id);
    }
}
