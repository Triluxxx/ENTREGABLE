package com.project.lab_clinico.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "parametros")
public class ParametroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametro")
    private Long idParametro;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_unidad", nullable = false)
    @JsonIgnoreProperties("parametros")
    private UnidadEntity unidad;
    @Column(name = "es_analisis")
    private Boolean esAnalisis;
    @Column(name = "tipo_dato")
    @Enumerated(EnumType.STRING) // aqui falta solucionar
    private TipoDato tipoDato;
    @OneToMany(mappedBy = "parametro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("parametro")
    private List<ValorParametroEntity> valores;
    @ManyToOne
    @JoinColumn(name = "id_tipo_muestra", nullable = false)
    private TipoMuestraEntity tipoMuestra;

    // Getters y Setters
    public Long getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Long idParametro) {
        this.idParametro = idParametro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidadEntity getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadEntity unidad) {
        this.unidad = unidad;
    }

    public Boolean getEsAnalisis() {
        return esAnalisis;
    }

    public void setEsAnalisis(Boolean esAnalisis) {
        this.esAnalisis = esAnalisis;
    }

    public TipoDato getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(TipoDato tipoDato) {
        this.tipoDato = tipoDato;
    }

    public List<ValorParametroEntity> getValores() {
        return valores;
    }

    public void setValores(List<ValorParametroEntity> valores) {
        this.valores = valores;
    }

    public TipoMuestraEntity getTipoMuestra() {
        return tipoMuestra;
    }
    public void setTipoMuestra(TipoMuestraEntity tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }
}
