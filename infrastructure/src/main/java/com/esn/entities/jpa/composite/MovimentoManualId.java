package com.esn.entities.jpa.composite;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.io.Serializable;

@Embeddable
public class MovimentoManualId implements Serializable {

    @Column(name = "DAT_MES", nullable = false)
    private Integer mes;

    @Column(name = "DAT_ANO", nullable = false)
    private Integer ano;

    @Column(name = "NUM_LANCAMENTO", nullable = false)
    private Long numLancamento;

    @Embedded
    private ProdutoCosifId produtoCosifId;

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Long getNumLancamento() {
        return numLancamento;
    }

    public void setNumLancamento(Long numLancamento) {
        this.numLancamento = numLancamento;
    }

    public ProdutoCosifId getProdutoCosifId() {
        return produtoCosifId;
    }

    public void setProdutoCosifId(ProdutoCosifId produtoCosifId) {
        this.produtoCosifId = produtoCosifId;
    }
}