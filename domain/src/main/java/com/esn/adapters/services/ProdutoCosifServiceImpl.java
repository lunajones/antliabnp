package com.esn.adapters.services;

import com.esn.ports.DocumentoServicePort;
import com.esn.ports.ProdutoCosifRepositoryPort;

public class ProdutoCosifServiceImpl implements ProdutoCosifServicePort {

    private final ProdutoCosifRepositoryPort repositoryPort;
    private final DocumentoServicePort documentoServicePort;

    public ProdutoCosifServiceImpl(ProdutoCosifRepositoryPort repositoryPort, DocumentoServicePort documentoServicePort) {
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
