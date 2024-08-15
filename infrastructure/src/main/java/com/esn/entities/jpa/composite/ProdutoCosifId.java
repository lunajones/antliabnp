package com.esn.entities.jpa.composite;

import com.esn.entities.jpa.ProdutoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ProdutoCosifId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO", nullable = false)
    private ProdutoEntity produto;

    @Column(name = "COD_COSIF", nullable = false, length = 11)
    private String codigoCosif;

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    public String getCodigoCosif() {
        return codigoCosif;
    }

    public void setCodigoCosif(String codigoCosif) {
        this.codigoCosif = codigoCosif;
    }
}