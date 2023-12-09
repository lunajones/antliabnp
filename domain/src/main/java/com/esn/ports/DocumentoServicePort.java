package com.esn.ports;

import com.esn.Beneficiario;
import com.esn.Documento;

import java.util.List;
import java.util.UUID;

public interface DocumentoServicePort {


    List<Documento> findAllByBeneficiarioId(UUID id);

    List<Documento> saveAll(List<Documento> documentos, UUID beneficiarioId);

    List<Documento> modify(List<Documento> documentos, Beneficiario beneficiario);

    void deleteAllByBeneficiarioId(UUID beneficiarioId);

}
