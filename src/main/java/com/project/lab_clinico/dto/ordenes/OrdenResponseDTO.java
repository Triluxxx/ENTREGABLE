package com.project.lab_clinico.dto.ordenes;

import java.util.Date;
import java.util.List;

public class OrdenResponseDTO {
    private Long idOrden;
    private String codigoOrden;
    private String estado; // "PENDIENTE"
    private Date fechaCreacion;

    // Datos del paciente (puedes ajustar según prefieras)
    private Long idPaciente;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String dniPaciente;

    // Tipo de orden (opcional, pero recomendable)
    private String tipoOrden; // "PERFIL", "INDIVIDUAL", "MIXTA"

    // Listas de lo que seleccionó la laboratorista
    private List<String> nombresPerfiles;     // Ej: ["Hemograma"]
    private List<String> nombresParametros;   // Ej: ["VIH", "Glucosa"]

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(String tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    public List<String> getNombresPerfiles() {
        return nombresPerfiles;
    }

    public void setNombresPerfiles(List<String> nombresPerfiles) {
        this.nombresPerfiles = nombresPerfiles;
    }

    public List<String> getNombresParametros() {
        return nombresParametros;
    }

    public void setNombresParametros(List<String> nombresParametros) {
        this.nombresParametros = nombresParametros;
    }
}

