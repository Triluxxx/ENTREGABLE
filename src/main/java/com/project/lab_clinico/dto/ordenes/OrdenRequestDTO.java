package com.project.lab_clinico.dto.ordenes;

import com.project.lab_clinico.entity.TypeOrden;

import java.util.List;

public class OrdenRequestDTO {
    private Long idPaciente;
    private List<Long> perfilesSeleccionados;
    private List<Long> parametrosSeleccionados;

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public List<Long> getParametrosSeleccionados() {
        return parametrosSeleccionados;
    }

    public void setParametrosSeleccionados(List<Long> parametrosSeleccionados) {
        this.parametrosSeleccionados = parametrosSeleccionados;
    }

    public List<Long> getPerfilesSeleccionados() {
        return perfilesSeleccionados;
    }

    public void setPerfilesSeleccionados(List<Long> perfilesSeleccionados) {
        this.perfilesSeleccionados = perfilesSeleccionados;
    }
}