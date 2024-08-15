package com.esn;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Produto {

    private String codigo;

    private String descricao;

    private String status;


    public static ProdutoBuilder builder() { return new ProdutoBuilder();}

    public static final class ProdutoBuilder {
        private String codigo;
        private String descricao;
        private String status;
        private ProdutoBuilder() {
        }

        public static ProdutoBuilder aProduto() {
            return new ProdutoBuilder();
        }

        public ProdutoBuilder withCodigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public ProdutoBuilder withDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }
        public ProdutoBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Produto build() {
            Produto produto = new Produto();
            produto.codigo = this.codigo;
            produto.descricao = this.descricao;
            produto.status = this.status;
            return produto;
        }
    }

}
