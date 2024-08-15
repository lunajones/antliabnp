package com.esn.adapters.repository.spring;

import com.esn.adapters.repository.spring.jpa.JpaProdutoRepository;
import com.esn.ports.ProdutoRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

    private final JpaProdutoRepository jpaProdutoRepository;

    public ProdutoRepository(JpaProdutoRepository jpaProdutoRepository) {
        this.jpaProdutoRepository = jpaProdutoRepository;
    }

//    @Override
//    public List<Produto> findAll() {
//        return jpaProdutoRepository.findAll().stream().map(BeneficiarioEntity::toBeneficiario).collect(Collectors.toList());
//    }
//
//    @Override
//    public Produto findById(UUID id) {
//        Optional<BeneficiarioEntity> beneficiario = jpaProdutoRepository.findById(id);
//        return beneficiario.map(BeneficiarioEntity::toBeneficiario).orElse(null);
//    }
//
//    @Override
//    public Produto save(Produto produto) {
//
//        BeneficiarioEntity entity = ProdutoEntityMapper.INSTANCE.toBeneficiarioEntity(produto);
//        entity.setDocumentos(ProdutoCosifEntityMapper.INSTANCE.toDocumentosEntity(produto.getDocumentos()));
//        return this.jpaProdutoRepository.save(entity).toBeneficiario();
//
//    }
//
//    @Override
//    public void delete(UUID id) {
//        jpaProdutoRepository.deleteById(id);
//    }
}
