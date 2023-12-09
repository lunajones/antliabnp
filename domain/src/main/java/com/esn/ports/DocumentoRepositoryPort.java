package com.esn.ports;

import com.esn.Documento;

import java.util.List;
import java.util.UUID;

public interface DocumentoRepositoryPort {

    List<Documento> persistAll(List<Documento> documentos, UUID id);

    void updateAll(List<Documento> documentos);

    List<Documento> findAllByBeneficiarioId(UUID beneficiarioId);

    void deleteAllByBeneficiarioId(UUID beneficiarioId);

    void deleteAllByIds(List<UUID> ids);
}
