package com.project.lab_clinico.dto.ordenes;

import com.project.lab_clinico.entity.EstadoOrden;

import java.util.List;

public class OrdenUpdateDTO {
    private EstadoOrden estado;
    private List<Long> perfilesSeleccionados;
    private List<Long> parametrosSeleccionados;

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public List<Long> getPerfilesSeleccionados() {
        return perfilesSeleccionados;
    }

    public void setPerfilesSeleccionados(List<Long> perfilesSeleccionados) {
        this.perfilesSeleccionados = perfilesSeleccionados;
    }

    public List<Long> getParametrosSeleccionados() {
        return parametrosSeleccionados;
    }

    public void setParametrosSeleccionados(List<Long> parametrosSeleccionados) {
        this.parametrosSeleccionados = parametrosSeleccionados;
    }
}
