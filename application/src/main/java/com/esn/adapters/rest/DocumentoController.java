package com.esn.adapters.rest;

import com.esn.Documento;
import com.esn.adapters.rest.mappers.DocumentoMapper;
import com.esn.adapters.rest.responses.DocumentoResponse;
import com.esn.ports.DocumentoServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;


@RestController
@RequestMapping("/v1/documento")
public class DocumentoController {

    private final DocumentoServicePort documentoServicePort;

    public DocumentoController(DocumentoServicePort documentoServicePort) {
        this.documentoServicePort = documentoServicePort;
    }


    @GetMapping("/beneficiario/{id}")
    public ResponseEntity<List<DocumentoResponse>> findAllByBeneficiarioId(@PathVariable UUID id) {
        documentoServicePort.findAllByBeneficiarioId(id);

        List<Documento> documentos = documentoServicePort.findAllByBeneficiarioId(id);

        if(isNull(documentos)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(DocumentoMapper.INSTANCE.toResponsesFromDomains(documentos));
    }
}
