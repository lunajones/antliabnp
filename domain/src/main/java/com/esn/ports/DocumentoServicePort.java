package com.esn.ports;

import com.esn.Produto;
import com.esn.ProdutoCosif;

import java.util.List;
import java.util.UUID;

public interface DocumentoServicePort {


    List<ProdutoCosif> findAllByBeneficiarioId(UUID id);

    List<ProdutoCosif> saveAll(List<ProdutoCosif> produtoCosifs, UUID beneficiarioId);

    List<ProdutoCosif> modify(List<ProdutoCosif> produtoCosifs, Produto produto);

    void deleteAllByBeneficiarioId(UUID beneficiarioId);

}
