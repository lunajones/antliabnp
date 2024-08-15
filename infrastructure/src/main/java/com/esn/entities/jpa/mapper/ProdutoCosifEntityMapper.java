package com.esn.entities.jpa.mapper;

import com.esn.ProdutoCosif;
import com.esn.entities.jpa.ProdutoCosifEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ProdutoCosifEntityMapper {

    ProdutoCosifEntityMapper INSTANCE = Mappers.getMapper(ProdutoCosifEntityMapper.class);

    @Mapping(source = "id.codigoCosif", target = "id.codigoCosif")
    @Mapping(source = "id.codigoProduto", target = "id.codigoProduto")
    @Mapping(source = "codigoClassificacao", target = "codigoClassificacao")
    @Mapping(source = "status", target = "status")
    ProdutoCosif toProdutoCosif(ProdutoCosifEntity produtoCosifEntity);

    List<ProdutoCosif> toProdutosCosifs(List<ProdutoCosifEntity> produtosCosifsEntities);

    @Mapping(source = "id.codigoCosif", target = "id.codigoCosif")
    @Mapping(source = "id.codigoProduto", target = "id.codigoProduto")
    @Mapping(source = "codigoClassificacao", target = "codigoClassificacao")
    @Mapping(source = "status", target = "status")
    ProdutoCosifEntity toProdutoCosifEntity(ProdutoCosif produtoCosif);

    List<ProdutoCosifEntity> toProdutosCosifsEntities(List<ProdutoCosif> produtosCosifs);
}
