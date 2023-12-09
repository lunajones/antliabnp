package com.esn.entities.jpa;

import com.esn.Beneficiario;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.util.Assert.notNull;

@Entity(name="BENEFICIARIO")
@Table(name="BENEFICIARIO")
public class BeneficiarioEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "NOME")

    private String nome;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "DATA_INCLUSAO")
    @CreationTimestamp
    private LocalDateTime dataInclusao;

    @Column(name = "DATA_ATUALIZACAO")
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy="beneficiario")
    private List<DocumentoEntity> documentos;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public List<DocumentoEntity> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoEntity> documentos) {
        this.documentos = documentos;
    }

    public Beneficiario toBeneficiario(){
        return Beneficiario.BeneficiarioBuilder.aBeneficiario()
                .withId(this.id)
                .withNome(this.nome)
                .withDataNascimento(this.dataNascimento)
                .withTelefone(this.telefone)
                .withDocumentos(this.documentos != null ? this.documentos.stream().map(DocumentoEntity::toDocumento).collect(Collectors.toList()) : null)
                .withDataInclusao(this.dataInclusao)
                .withDataAtualizacao(this.dataAtualizacao)
                .build();

    }

}