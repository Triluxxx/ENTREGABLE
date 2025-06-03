package com.project.lab_clinico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "perfiles")
public class PerfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_perfil;
    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false)
    private AreaEntity area;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_tipo_muestra", nullable = false)
    private TipoMuestraEntity tipoMuestra;


    public long getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(long id_perfil) {
        this.id_perfil = id_perfil;
    }

    public AreaEntity getArea() {
        return area;
    }

    public void setArea(AreaEntity area) {
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoMuestraEntity getTipoMuestra() {
        return tipoMuestra;
    }

    public void setTipoMuestra(TipoMuestraEntity tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }
}
