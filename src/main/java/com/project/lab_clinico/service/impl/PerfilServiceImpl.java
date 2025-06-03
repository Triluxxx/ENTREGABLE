package com.project.lab_clinico.service.impl;

import com.project.lab_clinico.dto.perfil.PerfilRequestDTO;
import com.project.lab_clinico.entity.AreaEntity;
import com.project.lab_clinico.entity.PerfilEntity;
import com.project.lab_clinico.entity.TipoMuestraEntity;
import com.project.lab_clinico.repository.AreaRepository;
import com.project.lab_clinico.repository.PerfilRepository;
import com.project.lab_clinico.repository.TipoMuestraRepository;
import com.project.lab_clinico.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private TipoMuestraRepository tipoMuestraRepository;

    @Override
    public List<PerfilEntity> listarPerfiles() {
        return perfilRepository.findAll();
    }

    @Override
    public Optional<PerfilEntity> obtenerPerfilPorId(Long id) {
        return perfilRepository.findById(id);
    }

    @Override
    public PerfilEntity guardarPerfil(PerfilRequestDTO dto) {
// Buscar entidades relacionadas
        AreaEntity area = areaRepository.findById(dto.getIdArea())
                .orElseThrow(() -> new RuntimeException("Área no encontrada"));

        TipoMuestraEntity tipoMuestra = tipoMuestraRepository.findById(dto.getIdTipoMuestra())
                .orElseThrow(() -> new RuntimeException("Tipo de muestra no encontrado"));

        // Crear el perfil
        PerfilEntity perfil = new PerfilEntity();
        perfil.setNombre(dto.getNombre());
        perfil.setArea(area);
        perfil.setTipoMuestra(tipoMuestra);

        return perfilRepository.save(perfil);    }

    @Override
    public PerfilEntity actualizarPerfil(Long id, PerfilRequestDTO dto) {
        PerfilEntity perfilExistente = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado con ID: " + id));

        AreaEntity area = areaRepository.findById(dto.getIdArea())
                .orElseThrow(() -> new RuntimeException("Área no encontrada"));

        TipoMuestraEntity tipoMuestra = tipoMuestraRepository.findById(dto.getIdTipoMuestra())
                .orElseThrow(() -> new RuntimeException("Tipo de muestra no encontrado"));

        perfilExistente.setNombre(dto.getNombre());
        perfilExistente.setArea(area);
        perfilExistente.setTipoMuestra(tipoMuestra);

        return perfilRepository.save(perfilExistente);
    }

    @Override
    public void eliminarPerfil(Long id) {
        perfilRepository.deleteById(id);
    }
}
