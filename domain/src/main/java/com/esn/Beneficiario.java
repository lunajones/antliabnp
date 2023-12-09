package com.esn;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Beneficiario {

    private UUID id;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDateTime dataInclusao;
    private LocalDateTime dataAtualizacao;

    private List<Documento> documentos;


    public static BeneficiarioBuilder builder() { return new BeneficiarioBuilder();}

    public static final class BeneficiarioBuilder {
        private UUID id;
        private String nome;
        private String telefone;
        private LocalDate dataNascimento;
        private LocalDateTime dataInclusao;
        private LocalDateTime dataAtualizacao;
        private List<Documento> documentos;

        private BeneficiarioBuilder() {
        }

        public static BeneficiarioBuilder aBeneficiario() {
            return new BeneficiarioBuilder();
        }

        public BeneficiarioBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public BeneficiarioBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public BeneficiarioBuilder withTelefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public BeneficiarioBuilder withDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public BeneficiarioBuilder withDataInclusao(LocalDateTime dataInclusao) {
            this.dataInclusao = dataInclusao;
            return this;
        }

        public BeneficiarioBuilder withDataAtualizacao(LocalDateTime dataAtualizacao) {
            this.dataAtualizacao = dataAtualizacao;
            return this;
        }

        public BeneficiarioBuilder withDocumentos(List<Documento> documentos) {
            this.documentos = documentos;
            return this;
        }

        public Beneficiario build() {
            Beneficiario beneficiario = new Beneficiario();
            beneficiario.nome = this.nome;
            beneficiario.documentos = this.documentos;
            beneficiario.dataInclusao = this.dataInclusao;
            beneficiario.id = this.id;
            beneficiario.telefone = this.telefone;
            beneficiario.dataAtualizacao = this.dataAtualizacao;
            beneficiario.dataNascimento = this.dataNascimento;
            return beneficiario;
        }
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public LocalDateTime getDataInclusao() {
        return dataInclusao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }
}
