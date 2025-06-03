package com.project.lab_clinico.service;

import com.project.lab_clinico.entity.TipoMuestraEntity;

import java.util.List;
import java.util.Optional;

public interface TipoMuestraService {
    TipoMuestraEntity crear(TipoMuestraEntity tipoMuestra);
    List<TipoMuestraEntity> listarTodos();
    Optional<TipoMuestraEntity> obtenerPorId(Long id);
    TipoMuestraEntity actualizar(Long id, TipoMuestraEntity tipoMuestra);
    void eliminar(Long id);
}