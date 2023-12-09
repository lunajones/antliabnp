package com.esn.ports;

import com.esn.Beneficiario;

import java.util.List;
import java.util.UUID;

public interface BeneficiarioServicePort {

    public Beneficiario create(Beneficiario beneficiario);

    public List<Beneficiario> findAll();

    public Beneficiario findById(UUID id);

    public Beneficiario modify(Beneficiario beneficiario);

    public void remove(UUID id);

}
