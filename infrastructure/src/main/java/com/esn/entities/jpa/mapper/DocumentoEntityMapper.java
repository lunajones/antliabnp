package com.esn.entities.jpa.mapper;

import com.esn.Documento;
import com.esn.entities.jpa.DocumentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface DocumentoEntityMapper {

    DocumentoEntityMapper INSTANCE = Mappers.getMapper(DocumentoEntityMapper.class);

    DocumentoEntity toDocumentoEntity(Documento documento);

    List<DocumentoEntity> toDocumentosEntity(List<Documento> documentos);

    @Mapping(source = "id", target = "withId")
    @Mapping(source = "tipoDocumento", target = "withTipoDocumento")
    @Mapping(source = "descricao", target = "withDescricao")
    @Mapping(source = "dataInclusao", target = "withDataInclusao")
    @Mapping(source = "dataAtualizacao", target = "withDataAtualizacao")
    Documento toDocumento(DocumentoEntity documentosEntities);
}
