package com.esn.entities.jpa;

import com.esn.ProdutoCosif;
import com.esn.entities.jpa.composite.ProdutoCosifId;
import jakarta.persistence.*;

import java.util.List;

@Entity(name="PRODUTO_COSIF")
@Table(name="DOCUMENTO")
public class ProdutoCosifEntity {

    @EmbeddedId
    private ProdutoCosifId id;

    @Column(name = "COD_CLASSIFICACAO", length = 6)
    private String codigoClassificacao;

    @Column(name = "STA_STATUS", length = 1)
    private String status;

    @OneToMany(mappedBy = "produtoCosif", cascade = CascadeType.ALL)
    private List<MovimentoManualEntity> movimentosManuais;

    public ProdutoCosifId getId() {
        return id;
    }

    public void setId(ProdutoCosifId id) {
        this.id = id;
    }

    public String getCodigoClassificacao() {
        return codigoClassificacao;
    }

    public void setCodigoClassificacao(String codigoClassificacao) {
        this.codigoClassificacao = codigoClassificacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MovimentoManualEntity> getMovimentosManuais() {
        return movimentosManuais;
    }

    public void setMovimentosManuais(List<MovimentoManualEntity> movimentosManuais) {
        this.movimentosManuais = movimentosManuais;
    }

    public ProdutoCosif toProdutoCosif(){
        return ProdutoCosif.ProdutoCosifBuilder.aProdutoCosif()
                .withProduto(this.id.getProduto().toProduto())
                .withCodigoCosif(this.id.getCodigoCosif())
                .withCodigoClassificacao(this.codigoClassificacao)
                .withStatus(this.status)
                .build();

    }

}
