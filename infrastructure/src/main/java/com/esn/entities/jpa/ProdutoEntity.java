package com.esn.entities.jpa;

import com.esn.Produto;
import jakarta.persistence.*;

import java.util.stream.Collectors;

@Entity(name="PRODUTO")
@Table(name="PRODUTO")
public class ProdutoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String codigo;

    @Column(name = "DESC_PRODUTO")
    private String descricao;

    @Column(name = "STA_STATUS")
    private String status;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Produto toProduto(){
        return Produto.ProdutoBuilder.aProduto()
                .withCodigo(this.codigo)
                .withDescricao(this.descricao)
                .withStatus(this.status)
                .build();

    }

}