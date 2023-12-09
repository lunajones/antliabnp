package com.esn.adapters.services;

import com.esn.Beneficiario;
import com.esn.ports.BeneficiarioRepositoryPort;
import com.esn.ports.BeneficiarioServicePort;
import com.esn.ports.DocumentoServicePort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

public class BeneficiarioServiceImpl implements BeneficiarioServicePort {

    private final BeneficiarioRepositoryPort repositoryPort;
    private final DocumentoServicePort documentoServicePort;

    public BeneficiarioServiceImpl(BeneficiarioRepositoryPort repositoryPort, DocumentoServicePort documentoServicePort) {
        this.repositoryPort = repositoryPort;
        this.documentoServicePort = documentoServicePort;
    }

    @Override
    public Beneficiario create(Beneficiario beneficiario) {

        Beneficiario beneficiarioSaved = this.repositoryPort.save(beneficiario);

        return Beneficiario.BeneficiarioBuilder.aBeneficiario()
                .withId(beneficiarioSaved.getId())
                .withTelefone(beneficiarioSaved.getTelefone())
                .withDataNascimento(beneficiarioSaved.getDataNascimento())
                .withDocumentos(this.documentoServicePort.saveAll(beneficiario.getDocumentos(), beneficiarioSaved.getId()))
                .withNome(beneficiarioSaved.getNome())
                .withDataInclusao(beneficiarioSaved.getDataInclusao())
                .withDataAtualizacao(beneficiarioSaved.getDataAtualizacao())
                .build();
    }

    @Override
    public List<Beneficiario> findAll() {
        return this.repositoryPort.findAll();
    }

    @Override
    public Beneficiario findById(UUID id) {
        return this.repositoryPort.findById(id);
    }

    @Override
    public Beneficiario modify(Beneficiario beneficiario) {
        Beneficiario oldBeneficiario = this.findById(beneficiario.getId());
        if(isNull(oldBeneficiario)){
            return null;
        }
        Beneficiario beneficiarioToPersist = Beneficiario.BeneficiarioBuilder.aBeneficiario()
                .withId(beneficiario.getId())
                .withTelefone(beneficiario.getTelefone())
                .withDataNascimento(beneficiario.getDataNascimento())
                .withDocumentos(this.documentoServicePort.modify(beneficiario.getDocumentos(), beneficiario))
                .withNome(beneficiario.getNome())
                .withDataInclusao(oldBeneficiario.getDataInclusao())
                .withDataAtualizacao(LocalDateTime.now())
                .build();

        return this.repositoryPort.save(beneficiarioToPersist);
    }

    @Override
    @Transactional
    public void remove(UUID id) {
        this.documentoServicePort.deleteAllByBeneficiarioId(id);
        this.repositoryPort.delete(id);

    }
}
