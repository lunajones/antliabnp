package com.esn.adapters.rest.mappers;

import com.esn.Beneficiario;
import com.esn.Documento;
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
    Beneficiario toDomainFromRequest(BeneficiarioRequest request);

    @Mapping(source = "request.nome", target = "withNome")
    @Mapping(source = "request.telefone", target = "withTelefone")
    @Mapping(source = "request.dataNascimento", target = "withDataNascimento")
    @Mapping(source = "request.documentos", target = "withDocumentos", qualifiedByName = "convertToDomain")
    @Mapping(source = "id", target = "withId")
    Beneficiario toDomainFromRequestAndUUID(BeneficiarioRequest request, UUID id);


    @Mapping(source = "documentos", target = "documentos", qualifiedByName = "convertToResponses")
    BeneficiarioResponse toResponseFromDomain(Beneficiario beneficiario);

    List<BeneficiarioResponse> toResponsesFromDomains(List<Beneficiario> beneficiarios);


    @Named("convertToDomain")
    public static List<Documento> convertToDomain(List<DocumentoRequest> requests) {
        return requests.stream().map(DocumentoMapper.INSTANCE::toDomainFromRequest).collect(Collectors.toList());
    }

    @Named("convertToResponses")
    public static List<DocumentoResponse> convertToResponses(List<Documento> documentos) {
        return DocumentoMapper.INSTANCE.toResponsesFromDomains(documentos);
    }

}
