package com.esn.adapters.services;

import com.esn.Produto;
import com.esn.ProdutoCosif;
import com.esn.ports.MovimentoManualRepositoryPort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MovimentoManualServiceImpl implements MovimentoManualServicePort {

    private final MovimentoManualRepositoryPort repositoryPort;


    public MovimentoManualServiceImpl(MovimentoManualRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

//    @Override
//    public List<ProdutoCosif> findAllByBeneficiarioId(UUID beneficiarioId) {
//        return this.repositoryPort.findAllByBeneficiarioId(beneficiarioId);
//    }
//
//    @Override
//    public List<ProdutoCosif> saveAll(List<ProdutoCosif> produtoCosifs, UUID beneficiarioId) {
//        return this.repositoryPort.persistAll(produtoCosifs, beneficiarioId);
//    }
//
//    @Override
//    public List<ProdutoCosif> modify(List<ProdutoCosif> produtoCosifs, Produto produto) {
//        List<ProdutoCosif> oldProdutoCosifs = this.findAllByBeneficiarioId(produto.getCodigo());
//
//        List<ProdutoCosif> documentosToPersist = new ArrayList<>();
//        List<UUID> documentosIdsToDelete = new ArrayList<>();
//
//        oldProdutoCosifs.forEach(oldDocumento -> {
//            if(!produtoCosifs.contains(oldDocumento)){
//                documentosIdsToDelete.add(oldDocumento.getId());
//            }
//        });
//
//        produtoCosifs.forEach(newDocumento -> {
//
//            boolean contains = oldProdutoCosifs.contains(newDocumento);
//
//            if(contains){
//                ProdutoCosif oldProdutoCosifFound = oldProdutoCosifs.stream()
//                        .filter(oldDocumento -> oldDocumento.equals(newDocumento)).findFirst().orElse(new ProdutoCosif());
//
//                documentosToPersist.add(ProdutoCosif.DocumentoBuilder.aDocumento()
//                        .withId(oldProdutoCosifFound.getId())
//                        .withTipoDocumento(newDocumento.getTipoDocumento())
//                        .withDescricao(newDocumento.getDescricao())
//                        .withBeneficiario(produto)
//                        .withDataInclusao(oldProdutoCosifFound.getDataInclusao())
//                        .withDataAtualizacao(LocalDateTime.now())
//                        .build());
//            } else {
//                documentosToPersist.add(newDocumento);
//            }
//
//        });
//
//        this.repositoryPort.deleteAllByIds(documentosIdsToDelete);
//        return this.saveAll(documentosToPersist, produto.getCodigo());
//    }
//
//    @Override
//    public void deleteAllByBeneficiarioId(UUID beneficiarioId) {
//        this.repositoryPort.deleteAllByBeneficiarioId(beneficiarioId);
//
//    }
}