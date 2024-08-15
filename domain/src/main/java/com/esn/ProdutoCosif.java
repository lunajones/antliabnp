package com.esn;

import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProdutoCosif {

    private Produto produto;
    private String codigoCosif;
    private String codigoClassificacao;
    private String status;
    public static ProdutoCosifBuilder builder() {
        return new ProdutoCosifBuilder();
    }


    public static final class ProdutoCosifBuilder {
        private Produto produto;

        private String codigoCosif;

        private String codigoClassificacao;
        private String status;
        private LocalDateTime dataInclusao;
        private LocalDateTime dataAtualizacao;

        private ProdutoCosifBuilder() {
        }

        public static ProdutoCosifBuilder aProdutoCosif() {
            return new ProdutoCosifBuilder();
        }


        public ProdutoCosifBuilder withProduto(Produto produto) {
            this.produto = produto;
            return this;
        }

        public ProdutoCosifBuilder withCodigoCosif(String codigoCosif){
            this.codigoCosif = codigoCosif;
            return this;
        }

        public ProdutoCosifBuilder withCodigoClassificacao(String codigoClassificacao) {
            this.codigoClassificacao = codigoClassificacao;
            return this;
        }

        public ProdutoCosifBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        public ProdutoCosif build() {
            ProdutoCosif produtoCosif = new ProdutoCosif();
            produtoCosif.produto = this.produto;
            produtoCosif.codigoCosif = this.codigoCosif;
            produtoCosif.codigoClassificacao = this.codigoClassificacao;
            produtoCosif.status = this.status;
            return produtoCosif;
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public String getCodigoCosif() {
        return codigoCosif;
    }

    public String getCodigoClassificacao() {
        return codigoClassificacao;
    }

    public String getStatus() {
        return status;
    }


}