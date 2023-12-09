package com.esn.ports;

import com.esn.Beneficiario;

import java.util.List;
import java.util.UUID;

public interface BeneficiarioRepositoryPort {


    List<Beneficiario> findAll();

    Beneficiario findById(UUID id);
    Beneficiario save(Beneficiario beneficiario);

    void delete(UUID id);
}
