package com.project.lab_clinico.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "muestras")
public class MuestraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMuestra;
    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenesEntity orden;
    @ManyToOne
    @JoinColumn(name = "id_tipo_muestra", nullable = false)
    private TipoMuestraEntity tipoMuestra;
    private String codigoMuestra;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public Long getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(Long idMuestra) {
        this.idMuestra = idMuestra;
    }

    public OrdenesEntity getOrden() {
        return orden;
    }

    public void setOrden(OrdenesEntity orden) {
        this.orden = orden;
    }

    public String getCodigoMuestra() {
        return codigoMuestra;
    }

    public void setCodigoMuestra(String codigoMuestra) {
        this.codigoMuestra = codigoMuestra;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
