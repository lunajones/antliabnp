package com.esn.entities.jpa;

import com.esn.MovimentoManual;
import com.esn.entities.jpa.composite.MovimentoManualId;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="MOVIMENTO_MANUAL")
@Table(name="MOVIMENTO_MANUAL")
public class MovimentoManualEntity {

    @EmbeddedId
    private MovimentoManualId id;

    @MapsId("produtoCosifId.codigoProduto")
    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO", nullable = false)
    private ProdutoEntity produto;

    @MapsId("produtoCosifId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUTO", insertable = false, updatable = false),
            @JoinColumn(name = "COD_COSIF", referencedColumnName = "COD_COSIF", insertable = false, updatable = false)
    })
    private ProdutoCosifEntity produtoCosif;

    @Column(name = "DES_DESCRICAO", length = 50)
    private String descricao;

    @Column(name = "DAT_MOVIMENTO")
    private LocalDateTime dataMovimento;

    @Column(name = "COD_USUARIO", length = 15)
    private String codigoUsuario;

    @Column(name = "VAL_VALOR", precision = 18, scale = 2)
    private BigDecimal valor;

    public MovimentoManualId getId() {
        return id;
    }

    public void setId(MovimentoManualId id) {
        this.id = id;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    public ProdutoCosifEntity getProdutoCosif() {
        return produtoCosif;
    }

    public void setProdutoCosif(ProdutoCosifEntity produtoCosif) {
        this.produtoCosif = produtoCosif;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(LocalDateTime dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public MovimentoManual toMovimentoManual() {
        return MovimentoManual.MovimentoManualBuilder.aMovimentoManual()
                .withMes(this.id.getMes())
                .withAno(this.id.getAno())
                .withNumLancamento(this.id.getNumLancamento())
                .withProdutoCosif(this.produtoCosif != null ? this.produtoCosif.toProdutoCosif() : null)
                .withDescricao(this.descricao)
                .withDataMovimento(this.dataMovimento)
                .withCodigoUsuario(this.codigoUsuario)
                .withValor(this.valor)
                .build();
    }

}
