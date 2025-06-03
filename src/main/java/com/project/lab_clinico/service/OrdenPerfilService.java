package com.project.lab_clinico.service;

import com.project.lab_clinico.entity.OrdenPerfilEntity;
import com.project.lab_clinico.entity.OrdenesEntity;

import java.util.List;
import java.util.Optional;

public interface OrdenPerfilService {
    OrdenPerfilEntity crear(OrdenPerfilEntity ordenPerfil);
    Optional<OrdenPerfilEntity> obtenerPorId(Long id);
    List<OrdenPerfilEntity> listarTodos();
    OrdenPerfilEntity actualizar(Long id, OrdenPerfilEntity ordenPerfil);
    void eliminarPorOrden(OrdenesEntity orden);
    void eliminarPorOrden(Long idOrden);            // uso externo desde controller
}
