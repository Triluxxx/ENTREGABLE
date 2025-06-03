package com.project.lab_clinico.service.impl;

import com.project.lab_clinico.entity.OrdenParametroEntity;
import com.project.lab_clinico.entity.OrdenesEntity;
import com.project.lab_clinico.repository.OrdenParametroRepository;
import com.project.lab_clinico.repository.OrdenesRepository;
import com.project.lab_clinico.service.OrdenParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenParametroServiceImpl implements OrdenParametroService {

    @Autowired
    private OrdenParametroRepository repository;

    @Autowired
    private OrdenesRepository ordenesRepository;

    @Override
    public OrdenParametroEntity crear(OrdenParametroEntity ordenParametro) {
        return repository.save(ordenParametro);    }

    @Override
    public Optional<OrdenParametroEntity> obtenerPorId(Long id) {
        return repository.findById(id);    }

    @Override
    public List<OrdenParametroEntity> listarTodos() {
        return repository.findAll();    }

    @Override
    public OrdenParametroEntity actualizar(Long id, OrdenParametroEntity ordenParametro) {
        if (repository.existsById(id)) {
            ordenParametro.setId_orden_parametro(id);
            return repository.save(ordenParametro);
        } else {
            throw new RuntimeException("OrdenParametro no encontrada con ID: " + id);
        }
    }

    @Override
    public void eliminarPorOrden(Long idOrden) {
        OrdenesEntity orden = ordenesRepository.findById(idOrden)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con ID: " + idOrden));

        eliminarPorOrden(orden); // 🔁 Reutilizas el otro método, mantiene
    }

    @Override
    public void eliminarPorOrden(OrdenesEntity orden) {
        List<OrdenParametroEntity> lista = repository.findByOrden(orden);
        repository.deleteAll(lista);
    }


}
