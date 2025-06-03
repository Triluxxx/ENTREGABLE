package com.project.lab_clinico.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordenes")
public class OrdenesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orden;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacientEntity id_paciente;

    @Enumerated(EnumType.STRING)
    private TypeOrden tipo_orden;

    @Enumerated(EnumType.STRING)
    private EstadoOrden estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", updatable = false)
    private Date fecha_creacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion")
    private Date fecha_actualizacion;

    @Column(name = "codigo_orden", unique = true, nullable = false, updatable = false, length = 30)
    private String codigoOrden;
    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<MuestraEntity> muestras;
    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrdenPerfilEntity> ordenesPerfiles;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrdenParametroEntity> ordenesParametros;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_laboratorista", nullable = false)
    private LaboratoristaEntity laboratorista;

    public Long getId_orden() {
        return id_orden;
    }

    public void setId_orden(Long id_orden) {
        this.id_orden = id_orden;
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

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public TypeOrden getTipo_orden() {
        return tipo_orden;
    }

    public void setTipo_orden(TypeOrden tipo_orden) {
        this.tipo_orden = tipo_orden;
    }

    public PacientEntity getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(PacientEntity id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    @PrePersist
    public void prePersist() {
        if (codigoOrden == null) {
            this.codigoOrden = generarCodigoUnico();
        }
    }
    public List<MuestraEntity> getMuestras() {
        return muestras;
    }

    public void setMuestras(List<MuestraEntity> muestras) {
        this.muestras = muestras;
    }

    public List<OrdenPerfilEntity> getOrdenesPerfiles() {
        return ordenesPerfiles;
    }

    public void setOrdenesPerfiles(List<OrdenPerfilEntity> ordenesPerfiles) {
        this.ordenesPerfiles = ordenesPerfiles;
    }

    public List<OrdenParametroEntity> getOrdenesParametros() {
        return ordenesParametros;
    }

    public void setOrdenesParametros(List<OrdenParametroEntity> ordenesParametros) {
        this.ordenesParametros = ordenesParametros;
    }


    public LaboratoristaEntity getLaboratorista() {
        return laboratorista;
    }

    public void setLaboratorista(LaboratoristaEntity laboratorista) {
        this.laboratorista = laboratorista;
    }

    private String generarCodigoUnico() {
        String fecha = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
        String random = generarCadenaAleatoria(6);
        return "ORD-" + fecha + "-" + random;
    }

    private String generarCadenaAleatoria(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        java.util.Random random = new java.util.Random();
        StringBuilder sb = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return sb.toString();
    }

}
