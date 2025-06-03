package com.project.lab_clinico.service.impl;

import com.project.lab_clinico.entity.LaboratoristaEntity;
import com.project.lab_clinico.repository.LaboratoristaRepository;
import com.project.lab_clinico.service.LaboratoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoristaServiceimpl implements LaboratoristaService {

    @Autowired
    private LaboratoristaRepository laboratoristaRepository;

    @Override
    public List<LaboratoristaEntity> listar() {
        return laboratoristaRepository.findAll();
    }

    @Override
    public Optional<LaboratoristaEntity> buscarPorId(Long id) {
        return laboratoristaRepository.findById(id);
    }

    @Override
    public LaboratoristaEntity guardar(LaboratoristaEntity laboratorista) {
        return laboratoristaRepository.save(laboratorista);
    }

    @Override
    public LaboratoristaEntity actualizar(Long id, LaboratoristaEntity laboratorista) {
        return laboratoristaRepository.findById(id)
                .map(existing -> {
                    existing.setTurno(laboratorista.getTurno());
                    existing.setCorreo(laboratorista.getCorreo());
                    existing.setPassword(laboratorista.getPassword());
                    // Puedes actualizar más campos aquí si los tienes
                    return laboratoristaRepository.save(existing);
                }).orElseThrow(() -> new RuntimeException("Laboratorista no encontrado con id " + id));
    }

    @Override
    public void eliminar(Long id) {
        laboratoristaRepository.deleteById(id);
    }
}
