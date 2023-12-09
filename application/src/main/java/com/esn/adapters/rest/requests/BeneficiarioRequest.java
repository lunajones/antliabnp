package com.esn.adapters.rest.requests;

import java.time.LocalDate;
import java.util.List;

public class BeneficiarioRequest {

    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private List<DocumentoRequest> documentos;

    public BeneficiarioRequest(String nome, String telefone, LocalDate dataNascimento, List<DocumentoRequest> documentos) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.documentos = documentos;
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

    public List<DocumentoRequest> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoRequest> documentos) {
        this.documentos = documentos;
    }
}