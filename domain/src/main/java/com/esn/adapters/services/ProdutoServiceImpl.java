package com.esn.adapters.services;

import com.esn.Produto;
import com.esn.ports.ProdutoRepositoryPort;
import com.esn.ports.BeneficiarioServicePort;
import com.esn.ports.DocumentoServicePort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

public class ProdutoServiceImpl implements BeneficiarioServicePort {

    private final ProdutoRepositoryPort repositoryPort;
    private final DocumentoServicePort documentoServicePort;

    public ProdutoServiceImpl(ProdutoRepositoryPort repositoryPort, DocumentoServicePort documentoServicePort) {
        this.repositoryPort = repositoryPort;
        this.documentoServicePort = documentoServicePort;
    }

//    @Override
//    public Produto create(Produto produto) {
//
//        Produto produtoSaved = this.repositoryPort.save(produto);
//
//        return Produto.BeneficiarioBuilder.aBeneficiario()
//                .withId(produtoSaved.getCodigo())
//                .withTelefone(produtoSaved.getTelefone())
//                .withDataNascimento(produtoSaved.getDataNascimento())
//                .withDocumentos(this.documentoServicePort.saveAll(produto.getDocumentos(), produtoSaved.getCodigo()))
//                .withNome(produtoSaved.getNome())
//                .withDataInclusao(produtoSaved.getDataInclusao())
//                .withDataAtualizacao(produtoSaved.getDataAtualizacao())
//                .build();
//    }
//
//    @Override
//    public List<Produto> findAll() {
//        return this.repositoryPort.findAll();
//    }
//
//    @Override
//    public Produto findById(UUID id) {
//        return this.repositoryPort.findById(id);
//    }
//
//    @Override
//    public Produto modify(Produto produto) {
//        Produto oldProduto = this.findById(produto.getCodigo());
//        if(isNull(oldProduto)){
//            return null;
//        }
//        Produto produtoToPersist = Produto.BeneficiarioBuilder.aBeneficiario()
//                .withId(produto.getCodigo())
//                .withTelefone(produto.getTelefone())
//                .withDataNascimento(produto.getDataNascimento())
//                .withDocumentos(this.documentoServicePort.modify(produto.getDocumentos(), produto))
//                .withNome(produto.getNome())
//                .withDataInclusao(oldProduto.getDataInclusao())
//                .withDataAtualizacao(LocalDateTime.now())
//                .build();
//
//        return this.repositoryPort.save(produtoToPersist);
//    }
//
//    @Override
//    @Transactional
//    public void remove(UUID id) {
//        this.documentoServicePort.deleteAllByBeneficiarioId(id);
//        this.repositoryPort.delete(id);
//
//    }
}
