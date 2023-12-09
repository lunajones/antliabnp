package com.esn.entities.jpa.mapper;

import com.esn.Beneficiario;
import com.esn.entities.jpa.BeneficiarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeneficiarioEntityMapper {

    BeneficiarioEntityMapper INSTANCE = Mappers.getMapper(BeneficiarioEntityMapper.class);

    BeneficiarioEntity toBeneficiarioEntity(Beneficiario beneficiario);
}
