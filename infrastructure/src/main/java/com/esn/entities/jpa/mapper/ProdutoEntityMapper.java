package com.esn.entities.jpa.mapper;

import com.esn.Produto;
import com.esn.entities.jpa.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProdutoEntityMapper {

    ProdutoEntityMapper INSTANCE = Mappers.getMapper(ProdutoEntityMapper.class);

    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "descricao", target = "descricao")
    @Mapping(source = "status", target = "status")
    Produto toProduto(ProdutoEntity produtoEntity);

    List<Produto> toProdutos(List<ProdutoEntity> produtoEntities);

    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "descricao", target = "descricao")
    @Mapping(source = "status", target = "status")
    ProdutoEntity toProdutoEntity(Produto produto);

    List<ProdutoEntity> toProdutoEntities(List<Produto> produtos);
}
