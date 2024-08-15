package com.esn.adapters.repository.spring.jpa;

import com.esn.entities.jpa.ProdutoCosifEntity;
import com.esn.entities.jpa.composite.ProdutoCosifId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProdutoCosifRepository extends JpaRepository<ProdutoCosifEntity, ProdutoCosifId> {

//    @Query(value = "select * FROM DOCUMENTO d WHERE d.BENEFICIARIO_ID = :beneficiarioId", nativeQuery = true)
//    List<ProdutoCosifEntity> findAllByBeneficiarioId(UUID beneficiarioId);
//
//    @Modifying
//    @Query(value = "DELETE FROM DOCUMENTO WHERE BENEFICIARIO_ID = :beneficiarioId", nativeQuery = true)
//    void deleteAllByBeneficiarioId(UUID beneficiarioId);
}
