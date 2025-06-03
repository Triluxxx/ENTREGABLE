package com.project.lab_clinico.service.impl;

import com.project.lab_clinico.entity.MedicoEntity;
import com.project.lab_clinico.repository.MedicoRepository;
import com.project.lab_clinico.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    private  MedicoRepository medicoRepository;


    @Override
    public List<MedicoEntity> listarTodos() {
        return medicoRepository.findAll();
    }

    @Override
    public Optional<MedicoEntity> buscarPorId(Long id) {
        return medicoRepository.findById(id);
    }

    @Override
    public MedicoEntity guardar(MedicoEntity medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public MedicoEntity actualizar(Long id, MedicoEntity medico) {
        return medicoRepository.findById(id)
                .map(m -> {
                    m.setEspecialidad(medico.getEspecialidad());
                    m.setUserEntity(medico.getUserEntity());
                    // actualiza otras propiedades si las tienes
                    return medicoRepository.save(m);
                }).orElseThrow(() -> new RuntimeException("Médico no encontrado"));
    }

    @Override
    public void eliminar(Long id) {
        medicoRepository.deleteById(id);
    }
}
