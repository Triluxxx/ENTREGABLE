package com.project.lab_clinico.service.impl;

import com.project.lab_clinico.entity.PerfilParametroEntity;
import com.project.lab_clinico.repository.PerfilParametroRepository;
import com.project.lab_clinico.service.PerfilParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilParametroServiceImpl implements PerfilParametroService {

    @Autowired
    private PerfilParametroRepository repository;

    @Override
    public List<PerfilParametroEntity> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<PerfilParametroEntity> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public PerfilParametroEntity guardar(PerfilParametroEntity perfilParametro) {
        return repository.save(perfilParametro);
    }

    @Override
    public PerfilParametroEntity actualizar(Integer id, PerfilParametroEntity perfilParametro) {
        if (repository.existsById(id)) {
            perfilParametro.setId_perfil_parametro(Long.valueOf(id));
            return repository.save(perfilParametro);
        } else {
            throw new RuntimeException("No se encontró perfil_parametro con ID: " + id);
        }
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
