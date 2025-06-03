package com.project.lab_clinico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "perfil_parametro")
public class PerfilParametroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_perfil_parametro;

    @ManyToOne
    @JoinColumn(name = "id_perfil", nullable = false)
    private PerfilEntity perfil;

    @ManyToOne
    @JoinColumn(name = "id_parametro", nullable = false)
    private ParametroEntity parametro;

    public Long getId_perfil_parametro() {
        return id_perfil_parametro;
    }

    public void setId_perfil_parametro(Long id_perfil_parametro) {
        this.id_perfil_parametro = id_perfil_parametro;
    }

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public ParametroEntity getParametro() {
        return parametro;
    }

    public void setParametro(ParametroEntity parametro) {
        this.parametro = parametro;
    }
}
