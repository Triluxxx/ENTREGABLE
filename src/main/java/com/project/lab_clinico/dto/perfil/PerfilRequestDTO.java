package com.project.lab_clinico.dto.perfil;

public class PerfilRequestDTO {
    private String nombre;
    private Long idArea;
    private Long idTipoMuestra;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }

    public Long getIdTipoMuestra() {
        return idTipoMuestra;
    }

    public void setIdTipoMuestra(Long idTipoMuestra) {
        this.idTipoMuestra = idTipoMuestra;
    }
}
