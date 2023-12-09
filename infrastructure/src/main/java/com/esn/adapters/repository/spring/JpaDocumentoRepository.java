package com.esn.adapters.repository.spring;

import com.esn.entities.jpa.DocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaDocumentoRepository extends JpaRepository<DocumentoEntity, UUID> {

    @Query(value = "select * FROM DOCUMENTO d WHERE d.BENEFICIARIO_ID = :beneficiarioId", nativeQuery = true)
    List<DocumentoEntity> findAllByBeneficiarioId(UUID beneficiarioId);

    @Modifying
    @Query(value = "DELETE FROM DOCUMENTO WHERE BENEFICIARIO_ID = :beneficiarioId", nativeQuery = true)
    void deleteAllByBeneficiarioId(UUID beneficiarioId);
}
