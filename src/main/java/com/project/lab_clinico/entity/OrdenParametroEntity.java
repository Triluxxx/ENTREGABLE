package com.project.lab_clinico.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orden_parametro")
public class OrdenParametroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orden_parametro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenesEntity orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parametro", nullable = false)
    private ParametroEntity parametro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", updatable = false)
    private Date fecha_creacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion")
    private Date fecha_actualizacion;

    public Long getId_orden_parametro() {
        return id_orden_parametro;
    }

    public void setId_orden_parametro(Long id_orden_parametro) {
        this.id_orden_parametro = id_orden_parametro;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public ParametroEntity getParametro() {
        return parametro;
    }

    public void setParametro(ParametroEntity parametro) {
        this.parametro = parametro;
    }

    public OrdenesEntity getOrden() {
        return orden;
    }

    public void setOrden(OrdenesEntity orden) {
        this.orden = orden;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }
    @PrePersist
    protected void onCreate() {
        fecha_creacion = new Date();
        fecha_actualizacion = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        fecha_actualizacion = new Date();
    }
}
