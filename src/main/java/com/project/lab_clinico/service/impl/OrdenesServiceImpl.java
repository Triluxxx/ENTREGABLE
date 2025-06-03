package com.project.lab_clinico.service.impl;

import com.project.lab_clinico.dto.ordenes.OrdenRequestDTO;
import com.project.lab_clinico.dto.ordenes.OrdenResponseDTO;
import com.project.lab_clinico.dto.ordenes.OrdenUpdateDTO;
import com.project.lab_clinico.entity.*;
import com.project.lab_clinico.repository.*;
import com.project.lab_clinico.service.OrdenParametroService;
import com.project.lab_clinico.service.OrdenPerfilService;
import com.project.lab_clinico.service.OrdenesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdenesServiceImpl implements OrdenesService {
   @Autowired
   public OrdenesRepository ordenesRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private ParametroRepository parametroRepository;

    @Autowired
    private OrdenPerfilRepository ordenPerfilRepository;

    @Autowired
    private OrdenParametroRepository ordenParametroRepository;

    @Autowired
    private PacientRepository pacienteRepository;
    @Autowired
    private OrdenPerfilService ordenPerfilService;

    @Autowired
    private OrdenParametroService ordenParametroService;

    @Override
    @Transactional
    public OrdenesEntity crearOrden(OrdenRequestDTO dto) {
// Paso 1: Buscar paciente
        PacientEntity paciente = pacienteRepository.findById(dto.getIdPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        // Paso 2: Crear y guardar la orden
        OrdenesEntity orden = new OrdenesEntity();
        orden.setId_paciente(paciente);
        orden.setEstado(EstadoOrden.PENDIENTE);
        orden.setFecha_creacion(new Date());
        orden.setFecha_actualizacion(new Date());

        orden = ordenesRepository.save(orden);

        // Paso 3: Insertar perfiles
        if (dto.getPerfilesSeleccionados() != null) {
            for (Long idPerfil : dto.getPerfilesSeleccionados()) {
                PerfilEntity perfil = perfilRepository.findById(idPerfil)
                        .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

                OrdenPerfilEntity ordenPerfil = new OrdenPerfilEntity();
                ordenPerfil.setOrden(orden);
                ordenPerfil.setPerfil(perfil);
                ordenPerfil.setFecha_creacion(new Date());
                ordenPerfil.setFecha_actualizacion(new Date());

                ordenPerfilRepository.save(ordenPerfil);
            }
        }

        // Paso 4: Insertar parámetros individuales
        if (dto.getParametrosSeleccionados() != null) {
            for (Long idParametro : dto.getParametrosSeleccionados()) {
                ParametroEntity parametro = parametroRepository.findById(idParametro)
                        .orElseThrow(() -> new RuntimeException("Parámetro no encontrado"));

                if (!Boolean.TRUE.equals(parametro.getEsAnalisis())) {
                    throw new RuntimeException("El parámetro no es válido como análisis individual");
                }

                OrdenParametroEntity ordenParametro = new OrdenParametroEntity();
                ordenParametro.setOrden(orden);
                ordenParametro.setParametro(parametro);
                ordenParametro.setFecha_creacion(new Date());
                ordenParametro.setFecha_actualizacion(new Date());

                ordenParametroRepository.save(ordenParametro);
            }
        }
        // Paso 5: Retornar la orden creada
        return orden;
    }

    @Override
    public OrdenResponseDTO convertirEntityAResponseDTO(OrdenesEntity orden) {
        OrdenResponseDTO dto = new OrdenResponseDTO();
        dto.setIdOrden(orden.getId_orden());
        dto.setCodigoOrden(orden.getCodigoOrden());
        dto.setEstado(orden.getEstado().name());
        dto.setFechaCreacion(orden.getFecha_creacion());
        dto.setTipoOrden(orden.getTipo_orden().name());

        // Datos del paciente
        PacientEntity paciente = orden.getId_paciente();
        UserEntity user = paciente.getUserEntity();

        dto.setIdPaciente(paciente.getId_paciente());
        dto.setNombrePaciente(user.getNombres());
        dto.setApellidoPaciente(user.getApellidos());
        dto.setDniPaciente(user.getDni());

        // Nombres de perfiles
        List<String> nombresPerfiles = orden.getOrdenesPerfiles().stream()
                .map(op -> op.getPerfil().getNombre())
                .collect(Collectors.toList());
        dto.setNombresPerfiles(nombresPerfiles);

        // Nombres de parámetros
        List<String> nombresParametros = orden.getOrdenesParametros().stream()
                .map(op -> op.getParametro().getNombre())
                .collect(Collectors.toList());
        dto.setNombresParametros(nombresParametros);

        return dto;
    }

    @Override
    public List<OrdenResponseDTO> listarOrdenesPorLaboratorista(Long idLaboratorista) {
        List<OrdenesEntity> ordenes = ordenesRepository.findAllByLaboratorista_Id(idLaboratorista);
        return ordenes.stream()
                .map(this::convertirEntityAResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrdenResponseDTO obtenerOrdenDTOporId(Long id) {
        OrdenesEntity orden = ordenesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con id: " + id));
        return convertirEntityAResponseDTO(orden);
    }

    @Override
    public List<OrdenesEntity> listarTodas() {
        return ordenesRepository.findAll();
    }

    @Override
    @Transactional
    public OrdenesEntity actualizarOrden(Long id, OrdenUpdateDTO dto) {
        OrdenesEntity orden = ordenesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con ID: " + id));

        // Actualizar estado
        if (dto.getEstado() != null) {
            orden.setEstado(dto.getEstado());
        }

        orden.setFecha_actualizacion(new Date());
        orden = ordenesRepository.save(orden);

        // Eliminar y volver a registrar perfiles
        ordenPerfilService.eliminarPorOrden(orden);
        if (dto.getPerfilesSeleccionados() != null) {
            for (Long idPerfil : dto.getPerfilesSeleccionados()) {
                PerfilEntity perfil = perfilRepository.findById(idPerfil)
                        .orElseThrow(() -> new RuntimeException("Perfil no encontrado con ID: " + idPerfil));

                OrdenPerfilEntity ordenPerfil = new OrdenPerfilEntity();
                ordenPerfil.setOrden(orden);
                ordenPerfil.setPerfil(perfil);
                ordenPerfil.setFecha_creacion(new Date());
                ordenPerfil.setFecha_actualizacion(new Date());

                ordenPerfilService.crear(ordenPerfil);
            }
        }
        // Eliminar y volver a registrar parámetros
        ordenParametroService.eliminarPorOrden(orden);
        if (dto.getParametrosSeleccionados() != null) {
            for (Long idParametro : dto.getParametrosSeleccionados()) {
                ParametroEntity parametro = parametroRepository.findById(idParametro)
                        .orElseThrow(() -> new RuntimeException("Parámetro no encontrado con ID: " + idParametro));

                if (!Boolean.TRUE.equals(parametro.getEsAnalisis())) {
                    throw new RuntimeException("El parámetro no es válido como análisis individual");
                }

                OrdenParametroEntity ordenParametro = new OrdenParametroEntity();
                ordenParametro.setOrden(orden);
                ordenParametro.setParametro(parametro);
                ordenParametro.setFecha_creacion(new Date());
                ordenParametro.setFecha_actualizacion(new Date());

                ordenParametroService.crear(ordenParametro);
            }
        }

        return orden;
    }

    @Override
    public void eliminarOrden(Long id) {
        ordenesRepository.deleteById(id);
    }
}
