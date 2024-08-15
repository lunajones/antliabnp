package com.esn.adapters.repository.spring.jpa;

import com.esn.entities.jpa.MovimentoManualEntity;
import com.esn.entities.jpa.composite.MovimentoManualId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovimentoManualRepository extends JpaRepository<MovimentoManualEntity, MovimentoManualId> {
}