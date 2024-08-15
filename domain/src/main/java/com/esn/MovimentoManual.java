package com.esn;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovimentoManual {

    private Integer mes;
    private Integer ano;
    private Long numLancamento;
    private ProdutoCosif produtoCosif;
    private String descricao;
    private LocalDateTime dataMovimento;
    private String codigoUsuario;
    private BigDecimal valor;

    public static MovimentoManualBuilder builder() {
        return new MovimentoManualBuilder();
    }

    public static final class MovimentoManualBuilder {
        private Integer mes;
        private Integer ano;
        private Long numLancamento;
        private ProdutoCosif produtoCosif;
        private String descricao;
        private LocalDateTime dataMovimento;
        private String codigoUsuario;
        private BigDecimal valor;

        private MovimentoManualBuilder() {
        }

        public static MovimentoManualBuilder aMovimentoManual() {
            return new MovimentoManualBuilder();
        }

        public MovimentoManualBuilder withMes(Integer mes) {
            this.mes = mes;
            return this;
        }

        public MovimentoManualBuilder withAno(Integer ano) {
            this.ano = ano;
            return this;
        }

        public MovimentoManualBuilder withNumLancamento(Long numLancamento) {
            this.numLancamento = numLancamento;
            return this;
        }

        public MovimentoManualBuilder withProdutoCosif(ProdutoCosif produtoCosif) {
            this.produtoCosif = produtoCosif;
            return this;
        }

        public MovimentoManualBuilder withDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public MovimentoManualBuilder withDataMovimento(LocalDateTime dataMovimento) {
            this.dataMovimento = dataMovimento;
            return this;
        }

        public MovimentoManualBuilder withCodigoUsuario(String codigoUsuario) {
            this.codigoUsuario = codigoUsuario;
            return this;
        }

        public MovimentoManualBuilder withValor(BigDecimal valor) {
            this.valor = valor;
            return this;
        }

        public MovimentoManual build() {
            MovimentoManual movimentoManual = new MovimentoManual();
            movimentoManual.mes = this.mes;
            movimentoManual.ano = this.ano;
            movimentoManual.numLancamento = this.numLancamento;
            movimentoManual.produtoCosif = this.produtoCosif;
            movimentoManual.descricao = this.descricao;
            movimentoManual.dataMovimento = this.dataMovimento;
            movimentoManual.codigoUsuario = this.codigoUsuario;
            movimentoManual.valor = this.valor;
            return movimentoManual;
        }
    }

    public Integer getMes() {
        return mes;
    }

    public Integer getAno() {
        return ano;
    }

    public Long getNumLancamento() {
        return numLancamento;
    }

    public ProdutoCosif getProdutoCosif() {
        return produtoCosif;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataMovimento() {
        return dataMovimento;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public BigDecimal getValor() {
        return valor;
    }
}