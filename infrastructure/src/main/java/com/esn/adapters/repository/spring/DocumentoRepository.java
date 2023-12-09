package com.esn.adapters.repository.spring;

import com.esn.Documento;
import com.esn.entities.jpa.BeneficiarioEntity;
import com.esn.entities.jpa.DocumentoEntity;
import com.esn.entities.jpa.mapper.DocumentoEntityMapper;
import com.esn.ports.DocumentoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class DocumentoRepository implements DocumentoRepositoryPort {

    private final JpaDocumentoRepository jpaDocumentoRepository;

    public DocumentoRepository(JpaDocumentoRepository jpaDocumentoRepository) {
        this.jpaDocumentoRepository = jpaDocumentoRepository;
    }

    @Override
    public List<Documento> persistAll(List<Documento> documentos, UUID id) {
        List<DocumentoEntity> entities = DocumentoEntityMapper.INSTANCE.toDocumentosEntity(documentos);
        BeneficiarioEntity beneficiarioEntity = new BeneficiarioEntity();
        beneficiarioEntity.setId(id);
        entities.forEach(it -> it.setBeneficiario(beneficiarioEntity));
        return this.jpaDocumentoRepository.saveAll(entities).stream().map(DocumentoEntityMapper.INSTANCE::toDocumento).collect(Collectors.toList());


    }

    @Override
    public void updateAll(List<Documento> documentos) {

    }

    @Override
    public List<Documento> findAllByBeneficiarioId(UUID beneficiarioId) {
        return this.jpaDocumentoRepository.findAllByBeneficiarioId(
                beneficiarioId).stream().map(DocumentoEntityMapper.INSTANCE::toDocumento).collect(Collectors.toList());
    }

    @Override
    public void deleteAllByBeneficiarioId(UUID beneficiarioId) {
        this.jpaDocumentoRepository.deleteAllByBeneficiarioId(beneficiarioId);
    }

    @Override
    public void deleteAllByIds(List<UUID> ids) {
        this.jpaDocumentoRepository.deleteAllById(ids);
    }
}
