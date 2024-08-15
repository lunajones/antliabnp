package com.esn.adapters.rest.mappers;

import com.esn.ProdutoCosif;
import com.esn.adapters.rest.requests.DocumentoRequest;
import com.esn.adapters.rest.responses.DocumentoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DocumentoMapper {

    DocumentoMapper INSTANCE = Mappers.getMapper(DocumentoMapper.class);

    @Mapping(source = "tipoDocumento", target = "withTipoDocumento")
    @Mapping(source = "descricao", target = "withDescricao")
    ProdutoCosif toDomainFromRequest(DocumentoRequest request);
    List<DocumentoResponse> toResponsesFromDomains(List<ProdutoCosif> produtoCosifs);

}
