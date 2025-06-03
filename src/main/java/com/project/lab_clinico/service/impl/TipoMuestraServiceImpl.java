package com.project.lab_clinico.service.impl;

import com.project.lab_clinico.entity.TipoMuestraEntity;
import com.project.lab_clinico.repository.TipoMuestraRepository;
import com.project.lab_clinico.service.TipoMuestraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoMuestraServiceImpl implements TipoMuestraService {
    @Autowired
    private TipoMuestraRepository tipoMuestraRepository;

    @Override
    public TipoMuestraEntity crear(TipoMuestraEntity tipoMuestra) {
        return tipoMuestraRepository.save(tipoMuestra);    }

    @Override
    public List<TipoMuestraEntity> listarTodos() {
        return tipoMuestraRepository.findAll();    }

    @Override
    public Optional<TipoMuestraEntity> obtenerPorId(Long id) {
        return tipoMuestraRepository.findById(id);    }

    @Override
    public TipoMuestraEntity actualizar(Long id, TipoMuestraEntity tipoMuestra) {
        TipoMuestraEntity existente = tipoMuestraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de muestra no encontrado"));

        existente.setNombre(tipoMuestra.getNombre());
        return tipoMuestraRepository.save(existente);

    }
    @Override
    public void eliminar(Long id) {
        tipoMuestraRepository.deleteById(id);
    }
}
