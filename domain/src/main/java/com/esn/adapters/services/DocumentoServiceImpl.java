package com.esn.adapters.services;

import com.esn.Beneficiario;
import com.esn.Documento;
import com.esn.ports.BeneficiarioServicePort;
import com.esn.ports.DocumentoRepositoryPort;
import com.esn.ports.DocumentoServicePort;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DocumentoServiceImpl implements DocumentoServicePort {

    private final DocumentoRepositoryPort repositoryPort;


    public DocumentoServiceImpl(DocumentoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Documento> findAllByBeneficiarioId(UUID beneficiarioId) {
        return this.repositoryPort.findAllByBeneficiarioId(beneficiarioId);
    }

    @Override
    public List<Documento> saveAll(List<Documento> documentos, UUID beneficiarioId) {
        return this.repositoryPort.persistAll(documentos, beneficiarioId);
    }

    @Override
    public List<Documento> modify(List<Documento> documentos, Beneficiario beneficiario) {
        List<Documento> oldDocumentos = this.findAllByBeneficiarioId(beneficiario.getId());

        List<Documento> documentosToPersist = new ArrayList<>();
        List<UUID> documentosIdsToDelete = new ArrayList<>();

        oldDocumentos.forEach(oldDocumento -> {
            if(!documentos.contains(oldDocumento)){
                documentosIdsToDelete.add(oldDocumento.getId());
            }
        });

        documentos.forEach(newDocumento -> {

            boolean contains = oldDocumentos.contains(newDocumento);

            if(contains){
                Documento oldDocumentoFound = oldDocumentos.stream()
                        .filter(oldDocumento -> oldDocumento.equals(newDocumento)).findFirst().orElse(new Documento());

                documentosToPersist.add(Documento.DocumentoBuilder.aDocumento()
                        .withId(oldDocumentoFound.getId())
                        .withTipoDocumento(newDocumento.getTipoDocumento())
                        .withDescricao(newDocumento.getDescricao())
                        .withBeneficiario(beneficiario)
                        .withDataInclusao(oldDocumentoFound.getDataInclusao())
                        .withDataAtualizacao(LocalDateTime.now())
                        .build());
            } else {
                documentosToPersist.add(newDocumento);
            }

        });

        this.repositoryPort.deleteAllByIds(documentosIdsToDelete);
        return this.saveAll(documentosToPersist, beneficiario.getId());
    }

    @Override
    public void deleteAllByBeneficiarioId(UUID beneficiarioId) {
        this.repositoryPort.deleteAllByBeneficiarioId(beneficiarioId);

    }
}