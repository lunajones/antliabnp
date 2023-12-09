package com.esn;

import com.esn.enums.TipoDocumento;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Documento {

    private UUID id;
    private TipoDocumento tipoDocumento;
    private String descricao;
    private LocalDateTime dataInclusao;
    private LocalDateTime dataAtualizacao;

    private Beneficiario beneficiario;

    public static DocumentoBuilder builder() { return new DocumentoBuilder();}


    public static final class DocumentoBuilder {
        private UUID id;
        private TipoDocumento tipoDocumento;
        private String descricao;
        private LocalDateTime dataInclusao;
        private LocalDateTime dataAtualizacao;
        private Beneficiario beneficiario;

        private DocumentoBuilder() {
        }

        public DocumentoBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public static DocumentoBuilder aDocumento() {
            return new DocumentoBuilder();
        }

        public DocumentoBuilder withTipoDocumento(TipoDocumento tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
            return this;
        }

        public DocumentoBuilder withDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public DocumentoBuilder withDataInclusao(LocalDateTime dataInclusao) {
            this.dataInclusao = dataInclusao;
            return this;
        }

        public DocumentoBuilder withDataAtualizacao(LocalDateTime dataAtualizacao) {
            this.dataAtualizacao = dataAtualizacao;
            return this;
        }

        public DocumentoBuilder withBeneficiario(Beneficiario beneficiario) {
            this.beneficiario = beneficiario;
            return this;
        }

        public Documento build() {
            Documento documento = new Documento();
            documento.dataInclusao = this.dataInclusao;
            documento.id = this.id;
            documento.tipoDocumento = this.tipoDocumento;
            documento.dataAtualizacao = this.dataAtualizacao;
            documento.beneficiario = this.beneficiario;
            documento.descricao = this.descricao;
            return documento;
        }
    }

    public UUID getId() {
        return id;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataInclusao() {
        return dataInclusao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;
        return tipoDocumento == documento.tipoDocumento && Objects.equals(beneficiario, documento.beneficiario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDocumento, beneficiario);
    }
}
