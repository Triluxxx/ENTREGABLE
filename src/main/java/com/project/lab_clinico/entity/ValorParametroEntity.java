package com.project.lab_clinico.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "valor_parametro")
public class ValorParametroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valor_parametro")
    private Long idValorParametro;

    @ManyToOne
    @JoinColumn(name = "id_parametro")
    @JsonIgnoreProperties("valores")
    private ParametroEntity parametro;
    private String valor;

    // Getters y Setters
    public Long getIdValorParametro() {
        return idValorParametro;
    }

    public void setIdValorParametro(Long idValorParametro) {
        this.idValorParametro = idValorParametro;
    }

    public ParametroEntity getParametro() {
        return parametro;
    }

    public void setParametro(ParametroEntity parametro) {
        this.parametro = parametro;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
