package com.project.lab_clinico.service.impl;

import com.project.lab_clinico.entity.OrdenPerfilEntity;
import com.project.lab_clinico.entity.OrdenesEntity;
import com.project.lab_clinico.repository.OrdenPerfilRepository;
import com.project.lab_clinico.repository.OrdenesRepository;
import com.project.lab_clinico.service.OrdenPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenPerfilServiceImpl implements OrdenPerfilService {

    @Autowired
    OrdenPerfilRepository ordenPerfilRepository;
    @Autowired
    OrdenesRepository ordenesRepository;


    @Override
    public OrdenPerfilEntity crear(OrdenPerfilEntity ordenPerfil) {
        return ordenPerfilRepository.save(ordenPerfil);    }

    @Override
    public Optional<OrdenPerfilEntity> obtenerPorId(Long id) {
        return ordenPerfilRepository.findById(id);    }

    @Override
    public List<OrdenPerfilEntity> listarTodos() {
        return ordenPerfilRepository.findAll();    }

    @Override
    public OrdenPerfilEntity actualizar(Long id, OrdenPerfilEntity ordenPerfil) {
        if (ordenPerfilRepository.existsById(id)) {
            ordenPerfil.setId_orden_perfil(id);
            return ordenPerfilRepository.save(ordenPerfil);
        } else {
            throw new RuntimeException("OrdenPerfil no encontrada con ID: " + id);

        }
    }

    @Override
    public void eliminarPorOrden(OrdenesEntity orden) {
        List<OrdenPerfilEntity> lista = ordenPerfilRepository.findByOrden(orden);
        ordenPerfilRepository.deleteAll(lista);
    }

    @Override
    public void eliminarPorOrden(Long idOrden) {
        OrdenesEntity orden = ordenesRepository.findById(idOrden)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con ID: " + idOrden));

        eliminarPorOrden(orden); // usa el método interno ya existente
    }


}
