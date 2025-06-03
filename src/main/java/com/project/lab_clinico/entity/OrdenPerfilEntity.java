package com.project.lab_clinico.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orden_perfil")
public class OrdenPerfilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orden_perfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenesEntity orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil", nullable = false)
    private PerfilEntity perfil;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", updatable = false)
    private Date fecha_creacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion")
    private Date fecha_actualizacion;

    public Long getId_orden_perfil() {
        return id_orden_perfil;
    }

    public void setId_orden_perfil(Long id_orden_perfil) {
        this.id_orden_perfil = id_orden_perfil;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public OrdenesEntity getOrden() {
        return orden;
    }

    public void setOrden(OrdenesEntity orden) {
        this.orden = orden;
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
