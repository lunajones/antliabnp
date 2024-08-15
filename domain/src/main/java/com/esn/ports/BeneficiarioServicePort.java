package com.esn.ports;

import com.esn.Produto;

import java.util.List;
import java.util.UUID;

public interface BeneficiarioServicePort {

    public Produto create(Produto produto);

    public List<Produto> findAll();

    public Produto findById(UUID id);

    public Produto modify(Produto produto);

    public void remove(UUID id);

}
