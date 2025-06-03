package com.project.lab_clinico.service;

import com.project.lab_clinico.entity.OrdenParametroEntity;
import com.project.lab_clinico.entity.OrdenesEntity;

import java.util.List;
import java.util.Optional;

public interface OrdenParametroService {
    OrdenParametroEntity crear(OrdenParametroEntity ordenParametro);
    Optional<OrdenParametroEntity> obtenerPorId(Long id);
    List<OrdenParametroEntity> listarTodos();
    OrdenParametroEntity actualizar(Long id, OrdenParametroEntity ordenParametro);
    void eliminarPorOrden(Long idOrden); // este método se usará desde el controlador
    void eliminarPorOrden(OrdenesEntity orden);
}
