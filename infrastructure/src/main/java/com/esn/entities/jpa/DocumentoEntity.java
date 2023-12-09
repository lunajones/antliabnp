package com.esn.entities.jpa;

import com.esn.Documento;
import com.esn.enums.TipoDocumento;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity(name="DOCUMENTO")
@Table(name="DOCUMENTO")
public class DocumentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_DOCUMENTO")
    private TipoDocumento tipoDocumento;
    @Column(name = "DESCRICAO")

    private String descricao;
    @Column(name = "DATA_INCLUSAO")
    @CreationTimestamp
    private LocalDateTime dataInclusao;
    @Column(name = "DATA_ATUALIZACAO")
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "BENEFICIARIO_ID")
    private BeneficiarioEntity beneficiario;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDateTime dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public BeneficiarioEntity getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(BeneficiarioEntity beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Documento toDocumento(){
        return Documento.DocumentoBuilder.aDocumento()
                .withId(this.id)
                .withTipoDocumento(this.tipoDocumento)
                .withDescricao(this.descricao)
                .withDataInclusao(this.dataInclusao)
                .withDataAtualizacao(this.dataAtualizacao)
                .build();

    }

}
