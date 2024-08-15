package com.esn.entities.jpa.mapper;

import com.esn.MovimentoManual;
import com.esn.entities.jpa.MovimentoManualEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovimentoManualEntityMapper {

    MovimentoManualEntityMapper INSTANCE = Mappers.getMapper(MovimentoManualEntityMapper.class);

    @Mapping(source = "id.mes", target = "mes")
    @Mapping(source = "id.ano", target = "ano")
    @Mapping(source = "id.numLancamento", target = "numLancamento")
    @Mapping(source = "produtoCosif", target = "produtoCosif")
    @Mapping(source = "descricao", target = "descricao")
    @Mapping(source = "dataMovimento", target = "dataMovimento")
    @Mapping(source = "codigoUsuario", target = "codigoUsuario")
    @Mapping(source = "valor", target = "valor")
    MovimentoManual toMovimentoManual(MovimentoManualEntity movimentoManualEntity);

    List<MovimentoManual> toMovimentosManuais(List<MovimentoManualEntity> movimentosManuaisEntities);

    @Mapping(source = "mes", target = "id.mes")
    @Mapping(source = "ano", target = "id.ano")
    @Mapping(source = "numLancamento", target = "id.numLancamento")
    @Mapping(source = "produtoCosif", target = "produtoCosif")
    @Mapping(source = "descricao", target = "descricao")
    @Mapping(source = "dataMovimento", target = "dataMovimento")
    @Mapping(source = "codigoUsuario", target = "codigoUsuario")
    @Mapping(source = "valor", target = "valor")
    MovimentoManualEntity toMovimentoManualEntity(MovimentoManual movimentoManual);

    List<MovimentoManualEntity> toMovimentosManuaisEntities(List<MovimentoManual> movimentosManuais);
}
