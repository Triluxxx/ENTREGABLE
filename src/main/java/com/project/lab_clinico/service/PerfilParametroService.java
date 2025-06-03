package com.project.lab_clinico.service;

import com.project.lab_clinico.entity.PerfilParametroEntity;

import java.util.List;
import java.util.Optional;

public interface PerfilParametroService {
    List<PerfilParametroEntity> listarTodos();
    Optional<PerfilParametroEntity> obtenerPorId(Integer id);
    PerfilParametroEntity guardar(PerfilParametroEntity perfilParametro);
    PerfilParametroEntity actualizar(Integer id, PerfilParametroEntity perfilParametro);
    void eliminar(Integer id);
}
