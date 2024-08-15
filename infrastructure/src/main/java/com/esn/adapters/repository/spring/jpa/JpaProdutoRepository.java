package com.esn.adapters.repository.spring.jpa;

import com.esn.entities.jpa.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {
}
