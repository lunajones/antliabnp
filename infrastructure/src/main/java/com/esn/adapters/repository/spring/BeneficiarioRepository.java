package com.esn.adapters.repository.spring;

import com.esn.Beneficiario;
import com.esn.entities.jpa.BeneficiarioEntity;
import com.esn.entities.jpa.mapper.BeneficiarioEntityMapper;
import com.esn.entities.jpa.mapper.DocumentoEntityMapper;
import com.esn.ports.BeneficiarioRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BeneficiarioRepository implements BeneficiarioRepositoryPort {

    private final JpaBeneficiarioRepository jpaBeneficiarioRepository;

    public BeneficiarioRepository(JpaBeneficiarioRepository jpaBeneficiarioRepository) {
        this.jpaBeneficiarioRepository = jpaBeneficiarioRepository;
    }

    @Override
    public List<Beneficiario> findAll() {
        return jpaBeneficiarioRepository.findAll().stream().map(BeneficiarioEntity::toBeneficiario).collect(Collectors.toList());
    }

    @Override
    public Beneficiario findById(UUID id) {
        Optional<BeneficiarioEntity> beneficiario = jpaBeneficiarioRepository.findById(id);
        return beneficiario.map(BeneficiarioEntity::toBeneficiario).orElse(null);
    }

    @Override
    public Beneficiario save(Beneficiario beneficiario) {

        BeneficiarioEntity entity = BeneficiarioEntityMapper.INSTANCE.toBeneficiarioEntity(beneficiario);
        entity.setDocumentos(DocumentoEntityMapper.INSTANCE.toDocumentosEntity(beneficiario.getDocumentos()));
        return this.jpaBeneficiarioRepository.save(entity).toBeneficiario();

    }

    @Override
    public void delete(UUID id) {
        jpaBeneficiarioRepository.deleteById(id);
    }
}
