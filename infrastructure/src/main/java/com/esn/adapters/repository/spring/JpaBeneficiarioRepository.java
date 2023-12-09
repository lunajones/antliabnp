package com.esn.adapters.repository.spring;

import com.esn.entities.jpa.BeneficiarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaBeneficiarioRepository extends JpaRepository<BeneficiarioEntity, UUID> {
}
