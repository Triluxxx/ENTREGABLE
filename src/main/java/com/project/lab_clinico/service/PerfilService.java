package com.project.lab_clinico.service;

import com.project.lab_clinico.dto.perfil.PerfilRequestDTO;
import com.project.lab_clinico.entity.PerfilEntity;

import java.util.List;
import java.util.Optional;

public interface PerfilService {
    List<PerfilEntity> listarPerfiles();
    Optional<PerfilEntity> obtenerPerfilPorId(Long id);
    PerfilEntity guardarPerfil(PerfilRequestDTO dto);
    PerfilEntity actualizarPerfil(Long id, PerfilRequestDTO dto);
    void eliminarPerfil(Long id);
}
