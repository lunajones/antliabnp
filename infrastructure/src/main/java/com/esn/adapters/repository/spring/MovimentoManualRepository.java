package com.esn.adapters.repository.spring;

import com.esn.adapters.repository.spring.jpa.JpaMovimentoManualRepository;
import com.esn.ports.MovimentoManualRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class MovimentoManualRepository implements MovimentoManualRepositoryPort {

    private final JpaMovimentoManualRepository jpaMovimentoManualRepository;

    public MovimentoManualRepository(JpaMovimentoManualRepository jpaMovimentoManualRepository) {
        this.jpaMovimentoManualRepository = jpaMovimentoManualRepository;
    }

//    @Override
//    public List<ProdutoCosif> persistAll(List<ProdutoCosif> produtoCosifs, UUID id) {
//        List<ProdutoCosifEntity> entities = ProdutoCosifEntityMapper.INSTANCE.toDocumentosEntity(produtoCosifs);
//        BeneficiarioEntity beneficiarioEntity = new BeneficiarioEntity();
//        beneficiarioEntity.setId(id);
//        entities.forEach(it -> it.setBeneficiario(beneficiarioEntity));
//        return this.jpaProdutoCosifRepository.saveAll(entities).stream().map(ProdutoCosifEntityMapper.INSTANCE::toDocumento).collect(Collectors.toList());
//
//
//    }
//
//    @Override
//    public void updateAll(List<ProdutoCosif> produtoCosifs) {
//
//    }
//
//    @Override
//    public List<ProdutoCosif> findAllByBeneficiarioId(UUID beneficiarioId) {
//        return this.jpaProdutoCosifRepository.findAllByBeneficiarioId(
//                beneficiarioId).stream().map(ProdutoCosifEntityMapper.INSTANCE::toDocumento).collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteAllByBeneficiarioId(UUID beneficiarioId) {
//        this.jpaProdutoCosifRepository.deleteAllByBeneficiarioId(beneficiarioId);
//    }
//
//    @Override
//    public void deleteAllByIds(List<UUID> ids) {
//        this.jpaProdutoCosifRepository.deleteAllById(ids);
//    }
}
