package com.esn.adapters.rest.mappers;

import com.esn.Produto;
import com.esn.ProdutoCosif;
import com.esn.adapters.rest.requests.BeneficiarioRequest;
import com.esn.adapters.rest.requests.DocumentoRequest;
import com.esn.adapters.rest.responses.BeneficiarioResponse;
import com.esn.adapters.rest.responses.DocumentoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper
public interface BeneficiarioMapper {

    BeneficiarioMapper INSTANCE = Mappers.getMapper(BeneficiarioMapper.class);

    @Mapping(source = "nome", target = "withNome")
    @Mapping(source = "telefone", target = "withTelefone")
    @Mapping(source = "dataNascimento", target = "withDataNascimento")
    @Mapping(source = "documentos", target = "withDocumentos", qualifiedByName = "convertToDomain")
    Produto toDomainFromRequest(BeneficiarioRequest request);

    @Mapping(source = "request.nome", target = "withNome")
    @Mapping(source = "request.telefone", target = "withTelefone")
    @Mapping(source = "request.dataNascimento", target = "withDataNascimento")
    @Mapping(source = "request.documentos", target = "withDocumentos", qualifiedByName = "convertToDomain")
    @Mapping(source = "id", target = "withId")
    Produto toDomainFromRequestAndUUID(BeneficiarioRequest request, UUID id);


    @Mapping(source = "documentos", target = "documentos", qualifiedByName = "convertToResponses")
    BeneficiarioResponse toResponseFromDomain(Produto produto);

    List<BeneficiarioResponse> toResponsesFromDomains(List<Produto> produtos);


    @Named("convertToDomain")
    public static List<ProdutoCosif> convertToDomain(List<DocumentoRequest> requests) {
        return requests.stream().map(DocumentoMapper.INSTANCE::toDomainFromRequest).collect(Collectors.toList());
    }

    @Named("convertToResponses")
    public static List<DocumentoResponse> convertToResponses(List<ProdutoCosif> produtoCosifs) {
        return DocumentoMapper.INSTANCE.toResponsesFromDomains(produtoCosifs);
    }

}
