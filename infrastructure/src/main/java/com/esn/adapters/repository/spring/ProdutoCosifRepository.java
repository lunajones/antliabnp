package com.esn.adapters.repository.spring;

import com.esn.adapters.repository.spring.jpa.JpaProdutoCosifRepository;
import com.esn.ports.ProdutoCosifRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class ProdutoCosifRepository implements ProdutoCosifRepositoryPort {

    private final JpaProdutoCosifRepository jpaProdutoCosifRepository;

    public ProdutoCosifRepository(JpaProdutoCosifRepository jpaProdutoCosifRepository) {
        this.jpaProdutoCosifRepository = jpaProdutoCosifRepository;
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
