package com.project.lab_clinico.service;

import com.project.lab_clinico.dto.ordenes.OrdenRequestDTO;
import com.project.lab_clinico.dto.ordenes.OrdenResponseDTO;
import com.project.lab_clinico.dto.ordenes.OrdenUpdateDTO;
import com.project.lab_clinico.entity.OrdenesEntity;

import java.util.List;
import java.util.Optional;

public interface OrdenesService {
    OrdenesEntity crearOrden(OrdenRequestDTO dto);
    OrdenResponseDTO obtenerOrdenDTOporId(Long id);
    OrdenResponseDTO convertirEntityAResponseDTO(OrdenesEntity orden);
    List<OrdenResponseDTO> listarOrdenesPorLaboratorista(Long idLaboratorista);
    List<OrdenesEntity> listarTodas();
    OrdenesEntity actualizarOrden(Long id, OrdenUpdateDTO dto);
    void eliminarOrden(Long id);
}
